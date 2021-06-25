package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

public enum NotificationFieldsList {
    Code("Code"),
    Message("Message"),
    Additional("Additional");

    private final String mValue;
    private static final Map<String, NotificationFieldsList> mStaticValuesMap = new HashMap<>();

    static {
        for(NotificationFieldsList field : NotificationFieldsList.values()) {
            mStaticValuesMap.put(field.mValue, field);
        }
    }

    NotificationFieldsList(String value) {
        mValue = value;
    }

    public String getString() { return mValue; }
    public static NotificationFieldsList getValue (String value) { return mStaticValuesMap.get(value); }
}
