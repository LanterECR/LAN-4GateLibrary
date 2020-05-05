package org.lanter.lan4gate;

import org.lanter.lan4gate.Implementation.Communication.TCPCommunication;
import org.lanter.lan4gate.Implementation.Communication.ICommunicationListener;
import org.lanter.lan4gate.Implementation.Messages.Fields.ClassFieldValuesList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Requests.Assembler.JSONAssembler;
import org.lanter.lan4gate.Implementation.Messages.Requests.Request;
import org.lanter.lan4gate.Implementation.Messages.Requests.RequestBuilder;
import org.lanter.lan4gate.Implementation.Messages.Responses.Parser.JSONParser;

import java.util.HashSet;
import java.util.Set;

/**
 * This class encapsulates ECR protocol LAN-4Gate
 */
public class Lan4Gate implements ICommunicationListener {
    private final Set<IResponseCallback> mResponseListeners = new HashSet<>();
    private final Set<INotificationCallback> mNotificationListeners = new HashSet<>();
    private final Set<ICommunicationCallback> mCommunicationListeners = new HashSet<>();
    private final Set<IErrorCallback> mErrorListeners = new HashSet<>();
    private final int mEcrNumber;
    private final TCPCommunication mTCPCommunication = new TCPCommunication();

    /**
     * Creates Lan4Gate object with ecrNumber
     *
     * @param ecrNumber Logical ECR number, used for communication with terminal. Value in range [1,999]
     */
    public Lan4Gate(int ecrNumber) {
        mEcrNumber = ecrNumber;
        mTCPCommunication.addCommunicationListener(this);
    }

    /**
     * Add listener for {@link IResponseCallback}
     *
     * @param callback Object, implements interface {@link IResponseCallback}
     */
    public void addResponseCallback(IResponseCallback callback) {
        mResponseListeners.add(callback);
    }

    /**
     * Remove registered {@link IResponseCallback} listener
     *
     * @param callback Registered {@link IResponseCallback} object
     */
    public void removeResponseCallback(IResponseCallback callback) {
        mResponseListeners.remove(callback);
    }

    /**
     * Add listener for {@link ICommunicationCallback}
     *
     * @param callback Object, implements interface {@link ICommunicationCallback}
     */
    public void addCommunicationCallback(ICommunicationCallback callback) {
        mCommunicationListeners.add(callback);
    }

    /**
     * Remove registered {@link ICommunicationCallback} listener
     *
     * @param callback Registered {@link ICommunicationCallback} object
     */
    public void removeCommunicationCallback(ICommunicationCallback callback) {
        mResponseListeners.remove(callback);
    }

    /**
     * Add listener for {@link INotificationCallback}
     *
     * @param callback Object, implements interface {@link INotificationCallback}
     */
    public void addNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.add(callback);
    }

    /**
     * Remove registered {@link INotificationCallback} listener
     *
     * @param callback Registered {@link INotificationCallback} object
     */
    public void removeNotificationCallback(INotificationCallback callback) {
        mNotificationListeners.remove(callback);
    }

    /**
     * Add listener for {@link IErrorCallback}
     *
     * @param callback Object, implements interface {@link IErrorCallback}
     */
    public void addErrorCallback(IErrorCallback callback) {
        mErrorListeners.add(callback);
    }

    /**
     * Remove registered {@link IErrorCallback} listener
     *
     * @param callback Registered {@link IErrorCallback} object
     */
    public void removeErrorCallback(IErrorCallback callback) {
        mErrorListeners.remove(callback);
    }

    /**
     * Sets working TCP port
     *
     * @param port Value in range [0, 65535]
     */
    public void setPort(int port) {
        mTCPCommunication.setPort(port);
    }

    /**
     * Returns using TCP port
     *
     * @return Value in range [0, 65535]
     */
    public int getPort() { return mTCPCommunication.getPort(); }

    /**
     * Sets IP for connection in TCP Client mode
     * Currently is STUB
     * @param ip String in format "127.0.0.1"
     */
    public void setIP(String ip) { }

    /**
     * Returns using IP
     *
     * @return String in format "127.0.0.1"
     */
    public String getIP() { return "127.0.0.1"; }

    /**
     * Start protocol communication. For TCP Server mode (default state) it starts thread for {@link java.nio.channels.Selector}
     * After correct start {@link ICommunicationCallback}.communicationStarted() will be called
     */
    public void start() {
        mTCPCommunication.startMonitoring();
    }

    /**
     * Returns start state of protocol communication
     *
     * @return True, if already and correct started
     */
    public boolean isStarted() {
        return mTCPCommunication.isStarted();
    }

    /**
     * Returns state of link opening. For TCP Server mode it`s returns status of server socket opening.
     * For TCP Client mode it`s returns status of client link opening
     *
     * @return True, if client link opened
     */
    public boolean linkIsOpen() {
        return mTCPCommunication.isOpen();
    }

    /**
     * Returns state of link connection. For TCP Server mode it`s returns status remote client connection.
     * For TCP Client mode it`s returns connection status to remote host.
     * @return True, if client is connected.
     */
    public boolean linkIsConnected() {
        return mTCPCommunication.isConnected();
    }

    /**
     * Stop protocol communication.
     * After correct start {@link ICommunicationCallback}.communicationStopped() will be called
     */
    public void stop() { mTCPCommunication.stopMonitoring(); }

    /**
     * Prepare and returns {@link IRequest} object.
     * Automatically fill ecrNumber, Type and mandatory fields
     *
     * @param operation One of {@link OperationsList} enum values
     *
     * @return Prepared object, implements {@link IRequest}
     */
    public IRequest getPreparedRequest(OperationsList operation) {
        RequestBuilder builder = new RequestBuilder(mEcrNumber);
        return builder.prepareRequest(operation);
    }

    /**
     * Send new request to terminal
     *
     * @param request Prepared object, implements {@link IRequest}
     */
    public void sendRequest(IRequest request){
        JSONAssembler assembler = new JSONAssembler();
        boolean result = assembler.assemble((Request) request);
        if(result) {
            mTCPCommunication.addSendData(assembler.getJson());
        }
    }
    @Override
    public void newData(String data) {
        JSONParser parser = new JSONParser();
        if(parser.parse(data)) {
            if(parser.getType() == ClassFieldValuesList.Response) {
                IResponse response = parser.getResponse();
                for (IResponseCallback callback : mResponseListeners) {
                    callback.newResponseMessage(response, this);
                }
            } else if(parser.getType() == ClassFieldValuesList.Notification) {
                INotification notification = parser.getNotification();
                for (INotificationCallback callback : mNotificationListeners) {
                    callback.newNotificationMessage(notification, this);
                }
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
