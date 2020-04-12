package org.lanter.lan4gate.Messages;

import java.util.HashMap;
import java.util.Map;

/**
 * Список классов сообщений
 */
public enum MessageClass {
    Request ("LANTER::Request"),
    Response ( "LANTER::Response"),
    Notification ( "LANTER::Notification");

    private final String mValue;
    private static final Map<String, MessageClass> mStaticValuesMap = new HashMap<>();

    static {
        for(MessageClass messageClass : MessageClass.values()) {
            mStaticValuesMap.put(messageClass.mValue, messageClass);
        }
    }
    MessageClass(String value) {
        mValue = value;
    }

    public String getString() {
        return mValue;
    }
    public static MessageClass getClass(String value) {
        return mStaticValuesMap.get(value);
    }
}
