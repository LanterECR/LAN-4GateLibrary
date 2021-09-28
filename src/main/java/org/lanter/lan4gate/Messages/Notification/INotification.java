package org.lanter.lan4gate.Messages.Notification;

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
     * Set {@link NotificationsList} for send
     * @param code one of {@link NotificationsList}
     */
    void setNotificationCode(NotificationsList code);

    /**
     * Return message text for display on screen. Additional info included
     *
     * @return the message
     */
    String getMessage();

    /**
     * Set message for notification
     * @param message String, contains message in UTF-8
     */
    void setMessage(String message);

    /**
     * Additional information of notification, such as try count for PIN input.
     * May not be exists. Provides by concrete code.
     *
     * @return Test string with additional info
     */
    String getAdditionalInfo();

    /**
     * Set additional info for notification. See documentation
     * @param additionalInfo String contains addiaional info
     */
    void setAdditionalInfo(String additionalInfo);
}
