package org.lanter.lan4gate.Messages.Interaction;

import java.util.HashMap;
import java.util.Map;

/**
 * List of interaction command
 */
public enum InteractionList {
    /**
     * Currently only wait card may be aborted
     */
    Abort(1);

    private final int mValue;
    private final static Map<Integer, InteractionList> mStaticValuesMap = new HashMap<>();

    static {
        for(InteractionList notification : InteractionList.values()) {
            mStaticValuesMap.put(notification.mValue, notification);
        }
    }

    InteractionList(int value) {
        mValue = value;
    }

    /**
     * Returns enum value which corresponds integer view
     *
     * @param value Interaction value
     *
     * @return Enum value, if value is correct. Null elsewhere
     */
    public static InteractionList getValue(int value) {
        return mStaticValuesMap.get(value);
    }

    /**
     * Returns integer value which corresponds current enum value
     *
     * @return Integer value of enum
     */
    public int getNumber() {
        return mValue;
    }
}
