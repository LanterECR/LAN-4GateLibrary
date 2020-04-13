package org.lanter.lan4gate.Messages;

import java.util.HashMap;
import java.util.Map;

/**
 * Список классов сообщений
 */
public enum MessageClassList {
    Request ("LANTER::Request"),
    Response ( "LANTER::Response"),
    Notification ( "LANTER::Notification");

    private final String mValue;
    private static final Map<String, MessageClassList> mStaticValuesMap = new HashMap<>();

    static {
        for(MessageClassList messageClass : MessageClassList.values()) {
            mStaticValuesMap.put(messageClass.mValue, messageClass);
        }
    }
    MessageClassList(String value) {
        mValue = value;
    }

    public static MessageClassList getValue(String value) {
        return mStaticValuesMap.get(value);
    }
    public String getString() {
        return mValue;
    }
}
