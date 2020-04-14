package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

public enum CardholderAuthMethodList {
    NoVerification(0),
    PinVerification(1),
    PaperSignatureVerification(2),
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
    public static CardholderAuthMethodList getValue(int operationValue) {
        return mStaticValuesMap.get(operationValue);
    }
    public int getNumber() {
        return mOperationValue;
    }
}
