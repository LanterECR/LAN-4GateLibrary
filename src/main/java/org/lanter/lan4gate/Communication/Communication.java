package org.lanter.lan4gate.Communication;

import org.lanter.lan4gate.Messages.Requests.Request;

import java.util.ArrayList;
import java.util.List;

public class Communication {
    private final int mEcrNumber;
    private final CommunicationType mCommunicationType;
    private final boolean mNeedRegistration;
    private List<IResponseCallback> mIResponseCallbackList = new ArrayList<>();
    private List<INotificationCallback> mNotificationCallbackList = new ArrayList<>();

    public Communication(int ecrNumber, CommunicationType type, boolean needRegistration) {
        mEcrNumber = ecrNumber;
        mCommunicationType = type;
        mNeedRegistration = needRegistration;
    }
    public Communication (int ecrNumber) {
        this(ecrNumber, CommunicationType.Server, false);
    }

    public boolean addResponseCallback(IResponseCallback callback) {
        boolean result = false;
        if(!mIResponseCallbackList.contains(callback)) {
            result = mIResponseCallbackList.add(callback);
        }
        return result;
     }
    public boolean removeResponseCallback(IResponseCallback callback) {
        return mIResponseCallbackList.remove(callback);
    }

    public boolean addNotificationCallback(INotificationCallback callback) {
        boolean result = false;
        if(!mNotificationCallbackList.contains(callback)) {
            result =mNotificationCallbackList.add(callback);
        }
        return result;
    }
    public boolean removeNotificationCallback(INotificationCallback callback) {
        return mNotificationCallbackList.remove(callback);
    }

    public void sendRequest(Request request){

    }
}