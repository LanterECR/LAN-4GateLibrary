package org.lanter.lan4gate.Implementation.MessageProcessor.Fields;

import java.util.HashMap;
import java.util.Map;

public enum ClassFieldValuesList {

    Request ("LANTER::Request"),

    Response ( "LANTER::Response"),

    Notification ( "LANTER::Notification"),

    Interaction("LANTER::Interaction");

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
