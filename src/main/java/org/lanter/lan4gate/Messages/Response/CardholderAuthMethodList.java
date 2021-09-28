package org.lanter.lan4gate.Messages.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum provides cardholder auth method in human readable view
 */
public enum CardholderAuthMethodList {

    /**
     * Cardholder no used any verification
     */
    NoVerification(0),

    /**
     * Cardholder has inputted pin
     */
    PinVerification(1),

    /**
     * Cardholder should signature receipt paper
     */
    PaperSignatureVerification(2),

    /**
     * Cardholder has verified on his own device
     */
    ClientDeviceVerification(3);

    private final int mOperationValue;
    private final static Map<Integer, CardholderAuthMethodList> mStaticValuesMap = new HashMap<>();

    static {
        for(CardholderAuthMethodList operation : CardholderAuthMethodList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    CardholderAuthMethodList(int value) {
        mOperationValue = value;
    }

    /**
     * Returns enum value which corresponds integer view
     *
     * @param value Card input method value
     *
     * @return Enum value, if value is correct. Null elsewhere
     */
    public static CardholderAuthMethodList getValue(int value) {
        return mStaticValuesMap.get(value);
    }

    /**
     * Returns integer value which corresponds current enum value
     *
     * @return Integer value of enum
     */
    public int getNumber() {
        return mOperationValue;
    }
}
