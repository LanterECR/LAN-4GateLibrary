package org.lanter.lan4gate.Communication;

import org.lanter.lan4gate.Messages.Requests.Request;

import java.util.ArrayList;
import java.util.List;

public class Communication {
    private final int mEcrNumber;
    private final CommunicationType mCommunicationType;
    private final boolean mNeedRegistration;
    private List<ResponseCallback> mResponseCallbackList = new ArrayList<>();
    private List<NotificationCallback> mNotificationCallbackList = new ArrayList<>();

    public Communication(int ecrNumber, CommunicationType type, boolean needRegistration) {
        mEcrNumber = ecrNumber;
        mCommunicationType = type;
        mNeedRegistration = needRegistration;
    }
    public Communication (int ecrNumber) {
        this(ecrNumber, CommunicationType.Server, false);
    }

    public boolean addResponseCallback(ResponseCallback callback) {
        boolean result = false;
        if(!mResponseCallbackList.contains(callback)) {
            result =mResponseCallbackList.add(callback);
        }
        return result;
     }
    public boolean removeResponseCallback(ResponseCallback callback) {
        return mResponseCallbackList.remove(callback);
    }

    public boolean addNotificationCallback(NotificationCallback callback) {
        boolean result = false;
        if(!mNotificationCallbackList.contains(callback)) {
            result =mNotificationCallbackList.add(callback);
        }
        return result;
    }
    public boolean removeNotificationCallback(NotificationCallback callback) {
        return mNotificationCallbackList.remove(callback);
    }

    public void sendRequest(Request request){

    }
}