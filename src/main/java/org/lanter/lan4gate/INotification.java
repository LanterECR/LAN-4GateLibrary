package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.NotificationsList;

/**
 * Интерфйс объекта уведомления о событии в терминале
 */
public interface INotification {
    /**
     * Возвращает код уведомления
     *
     * @return Код уведомления согласно перечислению {@link NotificationsList}
     */
    NotificationsList getNotificationCode();

    /**
     * Возвращает текстовое сообщение, полученное от терминала
     *
     * @return Текстовое сообщение от терминала. Строка в UTF-8
     */
    String getMessage();
}
