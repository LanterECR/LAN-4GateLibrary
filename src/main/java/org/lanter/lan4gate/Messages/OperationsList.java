package org.lanter.lan4gate.Messages;

import java.util.HashMap;
import java.util.Map;

public enum OperationsList {
    NoOperation(-1),
    //Sales operations

    Sale (1),

    MOTO (2),

    QuickPayment (3),

    PreAuth (200),

    SalesCompletion (201),

    FastTrack (300),

    //Void operations

    Void (400),

    VoidPartialSale (401),

    VoidPreAuth (402),

    //Refund operations

    Refund (500),

    RefundWithoutRRN (501),

    //Service operations

    Registration (800),

    TestCommunication (801),

    Test (802),

    PrintLastReceipt (803),

    GetLastOperation (804),

    PrintReceiptCopy (805),

    PrintDetailReport (806),

    PrintSummaryReport (807),

    Settlement (808),

    KeyDownload (809),

    Initialization (810),

    UpdateSW (811),

    PrintCommsInfo (812),

    PrintSoftInfo (813),

    FinalizeTransaction (814),

    GetCurrentPrinter (815),

    SetCurrentPrinter (816),

    SelfTest(817),

    GetOperationCopy(818),

    DisplayQR(819),

    SendLogs(820),

    SetLogLevel(821),

    LicenceActivationFile(822),

    LicenceActivationServer(823),

    ClearReversal(824),

    ClearAllJournals(825);

    private final int mOperationValue;
    private final static Map<Integer, OperationsList> mStaticValuesMap = new HashMap<>();

    static {
        for(OperationsList operation : OperationsList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    OperationsList(int value) {
        mOperationValue = value;
    }
    /**
     * Returns enum value which corresponds integer view
     *
     * @param value Card input method value
     *
     * @return Enum value, if value is correct. Null elsewhere
     */
    public static OperationsList getValue(int value) {
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
