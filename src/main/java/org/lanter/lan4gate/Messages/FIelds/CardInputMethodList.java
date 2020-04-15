package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

public enum CardInputMethodList {

    TerminalManualEntry(1),

    ExternalManualEntry(2),

    MagStrip(3),

    MagStripFallback(4),

    ChipFullGrade(5),

    ChipPartialGrade(6),

    ContactlessMagStripMode(7),

    ContactlessChipMode(8);

    private final int mOperationValue;
    private final static Map<Integer, CardInputMethodList> mStaticValuesMap = new HashMap<>();

    static {
        for(CardInputMethodList operation : CardInputMethodList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    CardInputMethodList(int value) {
        mOperationValue = value;
    }

    public static CardInputMethodList getValue(int operationValue) {
        return mStaticValuesMap.get(operationValue);
    }

    public int getNumber() {
        return mOperationValue;
    }
}
