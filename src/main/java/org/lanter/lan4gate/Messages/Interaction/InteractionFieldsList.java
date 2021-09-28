package org.lanter.lan4gate.Messages.Interaction;

import java.util.HashMap;
import java.util.Map;

public enum InteractionFieldsList {
    Code("Code");

    private final String mValue;
    private static final Map<String, InteractionFieldsList> mStaticValuesMap = new HashMap<>();

    static {
        for(InteractionFieldsList field : InteractionFieldsList.values()) {
            mStaticValuesMap.put(field.mValue, field);
        }
    }

    InteractionFieldsList(String value) {
        mValue = value;
    }

    public String getString() { return mValue; }
    public static InteractionFieldsList getValue (String value) { return mStaticValuesMap.get(value); }
}
