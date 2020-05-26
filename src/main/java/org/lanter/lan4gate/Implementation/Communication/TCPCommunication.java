package org.lanter.lan4gate.Implementation.Communication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TCPCommunication {
    private CommunicationType mCommunicationType = CommunicationType.TcpServer;
    private ServerSocketChannel mServerChannel;
    private Selector mConnectionSelector;
    private Thread mMonitoringThread;
    private SelectionKey mRegisteredConnection = null;
    private final ConcurrentLinkedQueue<ByteBuffer> mDataForSend = new ConcurrentLinkedQueue<>();
    private int mMaxConnectionsCount = 1;
    private int mPort = 20501;
    private String mIP;

    private final Set<ICommunicationListener> mNewDataListeners = new HashSet<>();
    private void setCommunicationType(CommunicationType type) {
        mCommunicationType = type;
    }
    private void setMaxConnectionCount(int maxConnectionCount) { mMaxConnectionsCount = maxConnectionCount;}

    private int getMaxConnectionCount() { return mMaxConnectionsCount; }

    private void setIP(String ip) { mIP = ip; }
    private String getIP() { return mIP; }

    public void addCommunicationListener(ICommunicationListener listener) {
        mNewDataListeners.add(listener);
    }
    public void removeCommunicationListener(ICommunicationListener listener) {
        mNewDataListeners.remove(listener);
    }

    public void setPort(int port) { mPort = port; }
    public int getPort() { return mPort; }
    public boolean isStarted() {
        boolean threadIsAlive = mMonitoringThread != null && mMonitoringThread.isAlive();
        return threadIsAlive;
    }
    public boolean isOpen () {
        boolean selectorIsOpen = mConnectionSelector != null && mConnectionSelector.isOpen();
        return  selectorIsOpen;
    }
    public boolean isConnected() {
        return mRegisteredConnection != null;
    }
    public void addSendData(String data) {
        mDataForSend.add(StandardCharsets.UTF_8.encode(data));
    }
    public void startMonitoring()
    {
        if(mMonitoringThread == null)
        {
            mMonitoringThread = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try
                    {
                        createSelector();
                        createTcpServer();
                        runServer();
                        runSelector();
                        stopSelector();
                    }
                    catch (IOException exception)
                    {
                        notifyException(exception);
                    }
                }
            });
            mMonitoringThread.start();
        }
    }
    public void stopMonitoring()
    {
        mMonitoringThread.interrupt();
        mMonitoringThread = null;
    }
    private void createSelector() throws IOException
    {
        if(mConnectionSelector == null)
        {
            mConnectionSelector = Selector.open();
        }
    }
    private void createTcpServer() throws IOException
    {
        if (mServerChannel == null)
        {
            //каналы платформозависимы, необходимо использовать фабрику
            mServerChannel = ServerSocketChannel.open();
            //в селекторах канал может быть только в неблокирующем состоянии
            mServerChannel.configureBlocking(false);
            //серверный канал регистрируется только на принятие соединения
            mServerChannel.register(mConnectionSelector, SelectionKey.OP_ACCEPT);
        }
    }
    private void runServer() throws IOException
    {
        mServerChannel.socket().bind(new InetSocketAddress(mPort));
    }
    private void stopSelector() throws IOException
    {
        try
        {
            for (SelectionKey selectionKey : mConnectionSelector.keys()) {
                try {
                    SelectableChannel channel = selectionKey.channel();

                    if (channel instanceof SocketChannel) {
                        SocketChannel socketChannel = (SocketChannel) channel;
                        socketChannel.close();
                        selectionKey.cancel();
                    } else if (channel instanceof ServerSocketChannel) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) channel;
                        serverSocketChannel.close();
                        selectionKey.cancel();
                    }
                } catch (IOException ignored) {

                }
            }
            mConnectionSelector.close();
            notifyCommunicationStopped();
        }
        catch (Exception ignored)
        {

        }
    }
    private void runSelector() throws IOException
    {
        notifyCommunicationStarted();
        while(!Thread.currentThread().isInterrupted())
        {
            int count = mConnectionSelector.selectNow();
            if (count == 0)
            {
                continue;
            }
            Set<SelectionKey> keys = mConnectionSelector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext())
            {
                SelectionKey key = iterator.next();
                try
                {
                    if(key.isAcceptable()) {
                        addConnection(registerChannelFromServer(getClientChannel(key)));
                    }
                    if (key.isReadable())
                    {
                        notifyNewData(readData(key));
                    }
                    if (key.isWritable())
                    {
                        sendData(key, extractData(key));
                    }
                } catch (Exception ignored)
                {
                }
                iterator.remove();
            }
        }
    }
    private void closeClientConnection(SelectionKey key) throws IOException
    {
        closeConnection(key);
        mDataForSend.clear();
        mRegisteredConnection = null;
        notifyDisconnected();
    }
    private void closeConnection(SelectionKey key) throws IOException{
        if (key.channel().isRegistered())
        {
            key.cancel();
        }
        key.channel().close();
    }
    private void addConnection(SelectionKey key) throws IOException
    {
        if(allowRegisterConnection()) {
            mRegisteredConnection = key;
            notifyConnected();
        } else {
            closeConnection(key);
        }
    }
    private void sendData(SelectionKey key, ByteBuffer buffer) throws IOException
    {
        if(buffer != null && key != null)
        {
            ((SocketChannel) key.channel()).write(buffer);
        }
    }
    private ByteBuffer extractData(SelectionKey key) throws IOException
    {
        ByteBuffer buffer = mDataForSend.peek();
        mDataForSend.poll();
        return buffer;
    }
    private SelectionKey registerChannelFromServer(SocketChannel channel) throws IOException
    {

        if(channel != null)
        {
            if(allowRegisterConnection()) {
                channel.configureBlocking(false);
                return channel.register(mConnectionSelector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            } else {
                channel.close();
            }
        }

        return null;
    }
    private SocketChannel getClientChannel(SelectionKey key) throws IOException
    {
        if (key != null) {
            if (key.channel() instanceof ServerSocketChannel) {
                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                return serverChannel.accept();
            }
        }
        return null;
    }
    private String readData(SelectionKey key) throws IOException
    {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buf = ByteBuffer.allocate(2048);
        StringBuilder builder = new StringBuilder();
        int bytes = channel.read(buf);
        while (bytes > 0)
        {
            buf.flip();
            String result = StandardCharsets.UTF_8.decode(buf).toString();
            builder.append(result);
            buf.clear();
            bytes = channel.read(buf);
        }
        if(bytes != -1)
        {
            return  builder.toString();
        }
        else
        {
            closeClientConnection(key);
        }
        return "";
    }
    public boolean allowRegisterConnection() {
        return mRegisteredConnection == null;
    }
    private void notifyNewData(final String newData) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ICommunicationListener listener : mNewDataListeners) {
                    listener.newData(newData);
                }
            }
        }).start();
    }
    private void notifyCommunicationStarted() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ICommunicationListener listener : mNewDataListeners) {
                    listener.communicationStarted();
                }
            }
        }).start();
    }

    private void notifyCommunicationStopped() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ICommunicationListener listener : mNewDataListeners) {
                    listener.communicationStopped();
                }
            }
        }).start();
    }

    private void notifyConnected() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ICommunicationListener listener : mNewDataListeners) {
                    listener.connected();
                }
            }
        }).start();
    }

    private void notifyDisconnected() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ICommunicationListener listener : mNewDataListeners) {
                    listener.disconnected();
                }
            }
        }).start();
    }
    private void notifyError(String message) {
        final String msg = message;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ICommunicationListener listener : mNewDataListeners) {
                    listener.errorMessage(msg);
                }
            }
        }).start();
    }
    private void notifyException(Exception exception) {
        final Exception exp = exception;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (ICommunicationListener listener : mNewDataListeners) {
                    listener.errorException(exp);
                }
            }
        }).start();
    }
}