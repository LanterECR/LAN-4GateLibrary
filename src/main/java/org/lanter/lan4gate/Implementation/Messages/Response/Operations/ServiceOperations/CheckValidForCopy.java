package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;

class CheckValidForCopy {
    public static boolean check(OperationsList operationCode) {
        return !operationCode.equals(OperationsList.GetOperationCopy) &&
                !operationCode.equals(OperationsList.PrintLastReceipt) &&
                !operationCode.equals(OperationsList.GetLastOperation) &&
                !operationCode.equals(OperationsList.PrintReceiptCopy);
    }
}
