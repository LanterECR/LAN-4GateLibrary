package org.lanter.lan4gate.Messages.Notification;

import org.lanter.lan4gate.Implementation.Messages.Notification.Notification;

public class NotificationFactory {
    public static INotification getNotification(NotificationsList notificationCode) {
        INotification notification = new Notification();
        notification.setNotificationCode(notificationCode);
        return notification;
    }
}
