package org.lanter.lan4gate.Messages;

import org.lanter.lan4gate.Messages.Fields.NotificationsList;

public class Notification {
    private final NotificationsList mNotification;
    private final String mMessage;

    public Notification(NotificationsList notification, String message) {
        mNotification = notification;
        mMessage = message;
    }
    public NotificationsList getNotification() { return mNotification; }
    public String getMessage() { return mMessage; }
}
