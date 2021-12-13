package org.lanter.lan4gate.Implementation.Communication;

import org.lanter.lan4gate.Communication.ICommunication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TCPClient implements ICommunication {
    private Selector mConnectionSelector;
    private SelectionKey mRegisteredConnection = null;
    private final Queue<byte[]> mDataForSend = new ConcurrentLinkedQueue<>();
    private final Queue<byte[]> mReceivedData = new ConcurrentLinkedQueue<>();
    private int mPort = 20501;
    private String mIP = "127.0.0.1";

    @Override
    public void openCommunication() throws IOException{
        createSelector();
        createTCPClient();
    }

    @Override
    public void closeCommunication() throws IOException {
        stopSelector();
    }

    public void setIP(String IP) {
        mIP = IP;
    }
    public String getIP() {
        return mIP;
    }
    public void setPort(int port) { mPort = port; }
    public int getPort() { return mPort; }

    @Override
    public void sendData(byte[] data) {
        mDataForSend.add(data);
    }

    @Override
    public byte[] getData() {
        return mReceivedData.poll();
    }

    @Override
    public void doCommunication() throws IOException{
        int count = mConnectionSelector.selectNow();

        if (count == 0) {
            return;
        }

        Set<SelectionKey> keys = mConnectionSelector.selectedKeys();
        Iterator<SelectionKey> iterator = keys.iterator();
        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            try {
                if(key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();

                    boolean isConnected = channel.isConnected();
                    boolean isPendingConnection = channel.isConnectionPending();
                    if (!isConnected && !isPendingConnection) {
                        channel.connect(new InetSocketAddress(getIP(), getPort()));
                    } else{
                        channel.finishConnect();
                        if(channel.isConnected()) {
                            addConnection(key);
                        }
                    }
                }
                if (key.isReadable())
                {
                    readData(key);
                }
                if (key.isWritable())
                {
                    sendData(key, extractData());
                }
            } catch (NotYetConnectedException e) {
                key.interestOps(SelectionKey.OP_CONNECT);
            } catch (ConnectException e) {
                key.cancel();
                createTCPClient();
            }
            catch (Exception ignored) {}
            iterator.remove();
        }
    }

    public boolean isOpen () {
        return mConnectionSelector != null && mConnectionSelector.isOpen();
    }

    @Override
    public void connect() throws IOException {

    }

    @Override
    public void disconnect() throws IOException {
        closeClientConnection(mRegisteredConnection);
    }

    public boolean isConnected() {
        return mRegisteredConnection != null;
    }

    private void createSelector() throws IOException {
        if(mConnectionSelector == null)
        {
            mConnectionSelector = Selector.open();
        }
    }
    private void createTCPClient() throws IOException {
        SocketChannel client = SocketChannel.open();
        client.configureBlocking(false);
        client.register(mConnectionSelector, SelectionKey.OP_CONNECT);
    }
    private void stopSelector() throws IOException {
        try
        {
            for (SelectionKey selectionKey : mConnectionSelector.keys()) {
                try {
                    SelectableChannel channel = selectionKey.channel();

                    if (channel instanceof SocketChannel) {
                        SocketChannel socketChannel = (SocketChannel) channel;
                        socketChannel.close();
                        selectionKey.cancel();
                    }
                } catch (IOException ignored) {

                }
            }
            mConnectionSelector.close();
        }
        catch (Exception ignored)
        {

        }
    }
    private void closeClientConnection(SelectionKey key) throws IOException {
        closeConnection(key);
        mDataForSend.clear();
        mReceivedData.clear();
        mRegisteredConnection = null;
    }
    private void closeConnection(SelectionKey key) throws IOException{
        if (key.channel().isRegistered())
        {
            key.cancel();
        }
        key.channel().close();
    }
    private void addConnection(SelectionKey key) throws IOException {
        if(allowRegisterConnection()) {
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            mRegisteredConnection = key;
        } else {
            closeConnection(key);
        }
    }
    private void sendData(SelectionKey key, byte[] buffer) throws IOException {
        if(buffer != null && key != null)
        {
            ((SocketChannel) key.channel()).write(ByteBuffer.wrap(buffer));
        }
    }
    private byte[] extractData() throws IOException {
        byte[] buffer = mDataForSend.peek();
        mDataForSend.poll();
        return buffer;
    }
    private SelectionKey registerChannelFromServer(SocketChannel channel) throws IOException {

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
    private SocketChannel getClientChannel(SelectionKey key) throws IOException {
        if (key != null) {
            if (key.channel() instanceof ServerSocketChannel) {
                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                return serverChannel.accept();
            }
        }
        return null;
    }
    private void readData(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ByteBuffer buf = ByteBuffer.allocate(2048);

        int bytes = channel.read(buf);

        while (bytes > 0)
        {
            buf.flip();
            outputStream.write(buf.array(), 0, bytes);
            buf.clear();
            bytes = channel.read(buf);
        }
        if(bytes  != -1) {
            mReceivedData.offer(outputStream.toByteArray());
        } else {
            closeClientConnection(key);
            createTCPClient();
        }
    }
    public boolean allowRegisterConnection() {
        return mRegisteredConnection == null;
    }
}
