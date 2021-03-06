package org.lanter.lan4gate;

/**
 * This interface provides callback for receive notification events from terminal.
 */
public interface INotificationCallback {

    /**
     * This callback will be called when the terminal sends an event notification during the operation.
     *
     * @param notification {@link INotification} implementation example, contains info about notification
     * @param initiator    Reference to {@link Lan4Gate} example, that has called this callback
     */
    void newNotificationMessage(INotification notification, Lan4Gate initiator);
}
