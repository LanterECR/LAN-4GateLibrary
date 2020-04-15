package org.lanter.lan4gate;

public interface INotificationCallback {

    void newNotificationMessage(INotification notification, Lan4Gate initiator);
}
