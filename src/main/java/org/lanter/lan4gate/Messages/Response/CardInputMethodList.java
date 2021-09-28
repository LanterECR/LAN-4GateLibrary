package org.lanter.lan4gate.Messages.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum provides card input method in human readable view.
 */
public enum CardInputMethodList {

    /**
     * The card data inputted manually in terminal
     */
    TerminalManualEntry(1),

    /**
     * The card data inputted manually outside from terminal. E.g. Internet
     */
    ExternalManualEntry(2),

    /**
     * The card was inputted into magnetic strip reader
     */
    MagStrip(3),

    /**
     * The card was inputted into magnetic strip reader after some errors occurred on chip reader
     */
    MagStripFallback(4),

    /**
     * The card was inputted in chip reader and was works by EMV Full grade scheme
     */
    ChipFullGrade(5),

    /**
     * Card inputted in chip reader and was works by EMV Partial grade scheme
     */
    ChipPartialGrade(6),

    /**
     * Card was presented to contactless reader and was using magnetic strip emulation
     */
    ContactlessMagStripMode(7),

    /**
     * Card was presented to contactless reader and was using chip emulation
     */
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

    /**
     * Returns enum value which corresponds integer view
     *
     * @param value Card input method value
     *
     * @return Enum value, if value is correct. Null elsewhere
     */
    public static CardInputMethodList getValue(int value) {
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
