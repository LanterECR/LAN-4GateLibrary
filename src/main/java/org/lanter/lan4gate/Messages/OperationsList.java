package org.lanter.lan4gate.Messages;

import java.util.HashMap;
import java.util.Map;

public enum OperationsList {
    NoOperation(-1),
    //Операции оплаты

    Sale (1),

    MOTO (2),

    QuickPayment (3),

    PreAuth (200),

    SalesCompletion (201),

    FastTrack (300),

    //Операции отмены

    Void (400),

    VoidPartialSale (401),

    VoidPreAuth (402),

    //Операции возврата

    Refund (500),

    RefundWithoutRRN (501),

    //Сервисные операции

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

    SelfTest(817);

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
    public static OperationsList getValue(int operationValue) {
        return mStaticValuesMap.get(operationValue);
    }
    public int getNumber() {
        return mOperationValue;
    }
}
