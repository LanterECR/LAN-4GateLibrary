package org.lanter.lan4gate;

/**
 * Callback для получения сообщений, уведомляющих о событиях терминала
 */
public interface INotificationCallback {
    /**
     * Callback-метод, в который будет отправлено уведомление
     *
     * @param notification Объект, содержащий уведомление о событии
     */
    void newNotificationMessage(INotification notification);
}
