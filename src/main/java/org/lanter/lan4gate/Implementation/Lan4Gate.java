package org.lanter.lan4gate.Implementation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.lanter.lan4gate.Communication.ICommunication;
import org.lanter.lan4gate.ILan4Gate;
import org.lanter.lan4gate.Communication.CommunicationFactory;
import org.lanter.lan4gate.MessageProcessor.Builder.IMessageBuilder;
import org.lanter.lan4gate.MessageProcessor.Builder.MessageBuilderFactory;
import org.lanter.lan4gate.MessageProcessor.Parser.IMessageParser;
import org.lanter.lan4gate.MessageProcessor.Parser.MessageParserFactory;
import org.lanter.lan4gate.Messages.Interaction.IInteraction;
import org.lanter.lan4gate.Messages.Notification.INotification;
import org.lanter.lan4gate.Messages.Notification.NotificationFactory;
import org.lanter.lan4gate.Messages.Notification.NotificationsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Request.IRequest;
import org.lanter.lan4gate.Messages.Request.RequestFactory;
import org.lanter.lan4gate.Messages.Response.IResponse;

import org.lanter.lan4gate.Callbacks.*;

public class Lan4Gate implements ILan4Gate, Runnable {
    private final Set<IResponseCallback> mResponseListeners = new HashSet<>();
    private final Set<INotificationCallback> mNotificationListeners = new HashSet<>();
    private final Set<ICommunicationCallback> mCommunicationListeners = new HashSet<>();

    private ICommunication mCommunication;

    private Thread mThread = null;

    private int mEcrNumber = -1;

    private volatile boolean mIsStarted = false;

    @Override
    public void setEcrNumber(int ecrNumber) {
        if(ecrNumber > 0) {
            mEcrNumber = ecrNumber;
        }
    }

    @Override
    public int getEcrNumber() {
        return mEcrNumber;
    }

    @Override
    public void setCommunication(ICommunication communication) throws RuntimeException {
        if(!isStarted()) {
            mCommunication = communication;
        } else {
            throw new RuntimeException("Stop Lan4Gate before change communication");
        }

    }

    @Override
    public ICommunication getCommunication() {
        return mCommunication;
    }

    @Override
    public void addResponseCallback(IResponseCallback callback) {
        mResponseListeners.add(callback);
    }

    @Override
    public void removeResponseCallback(IResponseCallback callback) {
        mResponseListeners.remove(callback);
    }

    @Override
    public void addCommunicationCallback(ICommunicationCallback callback) {
        mCommunicationListeners.add(callback);
    }

    @Override
    public void removeCommunicationCallback(ICommunicationCallback callback) {
        mCommunicationListeners.remove(callback);
    }

    @Override
    public void addNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.add(callback);
    }

    @Override
    public void removeNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.remove(callback);
    }

    @Override
    public void start() {
        if(mThread == null) {
            mThread = new Thread(this);

            mIsStarted = true;

            mThread.start();
        }
    }

    @Override
    public boolean isStarted() {
        return mIsStarted;
    }

    @Override
    public void stop() {
        if(mThread != null) {
            mIsStarted = false;
            mThread.interrupt();
            mThread = null;
        }
    }

    @Override
    public IRequest getPreparedRequest(OperationsList operation) {
        return RequestFactory.getRequest(operation, mEcrNumber);
    }

    @Override
    public void sendRequest(IRequest request){
        IMessageBuilder builder = MessageBuilderFactory.getBuilder();
        byte[] result = builder.buildMessage(request);
        if(result != null) {
            try {
                mCommunication.sendData(result);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public INotification getPreparedNotification(NotificationsList notification) {
        return NotificationFactory.getNotification(notification);
    }

    @Override
    public void sendInteraction(IInteraction interaction) {
        IMessageBuilder builder = MessageBuilderFactory.getBuilder();
        byte[] result = builder.buildMessage(interaction);
        if(result != null) {
            try {
                mCommunication.sendData(result);
            } catch (Exception ignored) {}
        }
    }

    private void newData(byte[] data) {
        if(data != null) {
            String convertedData = new String(data, StandardCharsets.UTF_8);

            IMessageParser parser = MessageParserFactory.getParser();

            switch (parser.parse(convertedData)) {
                case Response:
                    IResponse response = parser.getResponse();
                    for (IResponseCallback callback : mResponseListeners) {
                        callback.newResponseMessage(response, this);
                    }
                    break;
                case Notification:
                    INotification notification = parser.getNotification();
                    for (INotificationCallback callback : mNotificationListeners) {
                        callback.newNotificationMessage(notification, this);
                    }
                    break;
            }
        }
    }

    private void communicationStarted() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.communicationStarted(this);
        }
    }

    private void communicationStopped() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.communicationStopped(this);
        }
    }

    private void connected() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.connected(this);
        }
    }

    private void disconnected() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.disconnected(this);
        }
    }

    public void run() {
        if(mCommunication == null){
            mCommunication = CommunicationFactory.getSingleTCPServer();
        }

        boolean isConnected = false;
        while (mIsStarted && !Thread.currentThread().isInterrupted()) {
            try {
                if(mCommunication != null) {
                    if(!mCommunication.isOpen()) {
                        mCommunication.openCommunication();
                        communicationStarted();
                    }
                    mCommunication.doCommunication();
                    if(isConnected != mCommunication.isConnected()) {
                        isConnected = mCommunication.isConnected();

                        if(isConnected){
                            connected();
                        } else {
                            disconnected();
                        }
                    }

                    if(isConnected) {
                        newData(mCommunication.getData());
                    }
                }
            } catch (Exception e) {
            }
        }

        if(mCommunication != null) {
            try {
                mCommunication.closeCommunication();
            } catch (IOException e) {
            }
        }
        communicationStopped();
    }
}
