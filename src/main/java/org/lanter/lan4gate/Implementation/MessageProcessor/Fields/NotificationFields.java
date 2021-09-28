package org.lanter.lan4gate.Implementation.MessageProcessor.Fields;

import java.util.HashMap;
import java.util.Map;

public enum NotificationFields {
    Code("Code"),
    Message("Message"),
    Additional("Additional");

    private final String mValue;
    private static final Map<String, NotificationFields> mStaticValuesMap = new HashMap<>();

    static {
        for(NotificationFields field : NotificationFields.values()) {
            mStaticValuesMap.put(field.mValue, field);
        }
    }

    NotificationFields(String value) {
        mValue = value;
    }

    public String getString() { return mValue; }
    public static NotificationFields getValue (String value) { return mStaticValuesMap.get(value); }
}
