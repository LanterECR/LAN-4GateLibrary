package org.lanter.lan4gate.Implementation.Messages.Notification;

import org.lanter.lan4gate.Messages.Notification.INotification;
import org.lanter.lan4gate.Messages.Notification.NotificationsList;

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
