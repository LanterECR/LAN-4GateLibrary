package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

/**
 * Список классов сообщений
 */
public enum ClassFieldValuesList {
    /** Запрос от ECR в терминал*/
    Request ("LANTER::Request"),
    /** Ответ терминала на запрос*/
    Response ( "LANTER::Response"),
    /** Уведомление о событии терминала */
    Notification ( "LANTER::Notification");

    private final String mValue;
    private static final Map<String, ClassFieldValuesList> mStaticValuesMap = new HashMap<>();

    static {
        for(ClassFieldValuesList messageClass : ClassFieldValuesList.values()) {
            mStaticValuesMap.put(messageClass.mValue, messageClass);
        }
    }
    ClassFieldValuesList(String value) {
        mValue = value;
    }

    public static ClassFieldValuesList getValue(String value) {
        return mStaticValuesMap.get(value);
    }
    public String getString() {
        return mValue;
    }
}
