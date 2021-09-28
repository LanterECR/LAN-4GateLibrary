package org.lanter.lan4gate.Messages.Response;

import java.util.HashMap;
import java.util.Map;

public enum StatusList {

    UnknownError(-1),

    Success(1),

    Error(2),

    Decline(3),

    CommunicationError(4),

    OperationIsAutoReversal(5),

    EcrAlreadyRegistered(6),

    ConnectionLimitReached(7),

    ReceiptNotFound(8),

    TotalsNotAgreed(9),

    NeedSettlement(10),

    CanceledByTerminal(11),

    FastTrackKeyError(12);

    private final int mOperationValue;
    private final static Map<Integer, StatusList> mStaticValuesMap = new HashMap<>();

    static {
        for(StatusList operation : StatusList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    StatusList(int value) {
        mOperationValue = value;
    }

    public static StatusList getValue(int operationValue) {
        StatusList value;
        if(mStaticValuesMap.containsKey(operationValue)) {
            value = mStaticValuesMap.get(operationValue);
        }
        else {
            value = UnknownError;
        }
        return value;
    }

    public int getNumber() {
        return mOperationValue;
    }
}
