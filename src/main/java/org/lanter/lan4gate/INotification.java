package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.NotificationsList;

/**
 * This interface provide access for notification events from terminal.
 * You can use this interface in two cases:
 * 1. Get only notification code and display your own message considering additional info
 * 2. Get message text and display directly.
 */
public interface INotification {

    /**
     * Return notification code.
     *
     * @return Notification code is one of {@link NotificationsList}
     */
    NotificationsList getNotificationCode();

    /**
     * Return message text for display on screen. Additional info included
     *
     * @return the message
     */
    String getMessage();

    /**
     * Additional information of notification, such as try count for PIN input.
     * May not be exists. Provides by concrete code.
     *
     * @return Test string with additional info
     */
    String getAdditionalInfo();
}
