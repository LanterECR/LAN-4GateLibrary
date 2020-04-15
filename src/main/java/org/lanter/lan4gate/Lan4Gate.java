package org.lanter.lan4gate;

import org.lanter.lan4gate.Communication.Communication;
import org.lanter.lan4gate.Communication.ICommunicationListener;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Assembler.JSONAssembler;
import org.lanter.lan4gate.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.Requests.RequestBuilder;
import org.lanter.lan4gate.Messages.Responses.Parser.JSONParser;

import java.util.HashSet;
import java.util.Set;

public class Lan4Gate implements ICommunicationListener {
    private final Set<IResponseCallback> mResponseListeners = new HashSet<>();
    private final Set<INotificationCallback> mNotificationListeners = new HashSet<>();
    private final Set<ICommunicationCallback> mCommunicationListeners = new HashSet<>();
    private final Set<IErrorCallback> mErrorListeners = new HashSet<>();
    private final int mEcrNumber;
    private final Communication mCommunication = new Communication();

    public Lan4Gate(int ecrNumber) {
        mEcrNumber = ecrNumber;
        mCommunication.addCommunicationListener(this);
    }

    public void addResponseCallback(IResponseCallback callback) {
        mResponseListeners.add(callback);
    }

    public void removeResponseCallback(IResponseCallback callback) {
        mResponseListeners.remove(callback);
    }

    public void addCommunicationCallback(ICommunicationCallback callback) {
        mCommunicationListeners.add(callback);
    }

    public void removeCommunicationCallback(ICommunicationCallback callback) {
        mResponseListeners.remove(callback);
    }

    public void addNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.add(callback);
    }

    public void removeNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.remove(callback);
    }

    public void addErrorCallback(IErrorCallback callback) {
        mErrorListeners.add(callback);
    }

    public void removeErrorCallback(IErrorCallback callback) {
        mErrorListeners.remove(callback);
    }

    public void setPort(int port) {
        mCommunication.setPort(port);
    }

    public int getPort() { return mCommunication.getPort(); }

    public void setIP(String ip) { }

    public String getIP() { return "127.0.0.1"; }

    public void start() {
        mCommunication.startMonitoring();
    }

    public boolean isStarted() {
        return mCommunication.isStarted();
    }

    public boolean linkIsOpen() {
        return mCommunication.isOpen();
    }

    public boolean linkIsConnected() {
        return mCommunication.isConnected();
    }

    public void stop() { mCommunication.stopMonitoring(); }

    public IRequest getPreparedRequest(OperationsList operation) {
        RequestBuilder builder = new RequestBuilder(mEcrNumber);
        return builder.prepareRequest(operation);
    }

    public void sendRequest(IRequest request){
        JSONAssembler assembler = new JSONAssembler();
        boolean result = assembler.assemble((Request) request);
        if(result) {
            mCommunication.addSendData(assembler.getJson());
        }
    }
    @Override
    public void newData(String data) {
        JSONParser parser = new JSONParser();
        if(parser.parse(data)) {
            IResponse response = parser.getResponse();
            for(IResponseCallback callback : mResponseListeners) {
                callback.newResponseMessage(response, this);
            }
        }
    }

    @Override
    public void communicationStarted() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.communicationStarted(this);
        }
    }

    @Override
    public void communicationStopped() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.communicationStopped(this);
        }
    }

    @Override
    public void connected() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.connected(this);
        }
    }

    @Override
    public void disconnected() {
        for(ICommunicationCallback callback : mCommunicationListeners) {
            callback.disconnected(this);
        }
    }

    @Override
    public void errorMessage(String error) {
        for(IErrorCallback callback : mErrorListeners) {
            callback.errorMessage(error,this);
        }
    }

    @Override
    public void errorException(Exception exception) {
        for(IErrorCallback callback : mErrorListeners) {
            callback.errorException(exception, this);
        }
    }
}
