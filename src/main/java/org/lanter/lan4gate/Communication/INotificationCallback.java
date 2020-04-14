package org.lanter.lan4gate.Communication;

import org.lanter.lan4gate.Messages.Notification;

public interface INotificationCallback {
    void newNotificationMessage(Notification notification);
}
