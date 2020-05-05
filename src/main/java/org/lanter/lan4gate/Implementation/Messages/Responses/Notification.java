package org.lanter.lan4gate.Implementation.Messages.Responses;

import org.lanter.lan4gate.INotification;
import org.lanter.lan4gate.Messages.Fields.NotificationsList;

public class Notification implements INotification {
    private NotificationsList mNotificationType;
    private String mMessage;
    private String mAdditionalInfo;

    @Override
    public NotificationsList getNotificationCode() {
        return mNotificationType;
    }
    public void setNotificationCode(NotificationsList type) {
        mNotificationType = type;
    }
    @Override
    public String getMessage() {
        return mMessage;
    }
    public void setMessage(String message) {
        mMessage = message;
    }
    @Override
    public String getAdditionalInfo() {
        return mAdditionalInfo;
    }
    public void setAdditionalInfo(String additionalInfo) {
        mAdditionalInfo = additionalInfo;
    }
}
