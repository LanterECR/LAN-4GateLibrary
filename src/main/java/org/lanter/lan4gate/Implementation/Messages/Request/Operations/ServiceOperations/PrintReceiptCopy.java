package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class PrintReceiptCopy extends Request {
    public PrintReceiptCopy() {
        setOperationCode(OperationsList.PrintReceiptCopy);
        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addOptionalFields(RequestFieldsList.ReceiptReference);
    }
}
