package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.NotificationsList;

public interface INotification {

    NotificationsList getNotificationCode();

    String getMessage();
}
