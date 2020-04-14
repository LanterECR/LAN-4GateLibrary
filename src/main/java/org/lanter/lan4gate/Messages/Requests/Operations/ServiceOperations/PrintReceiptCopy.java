package org.lanter.lan4gate.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class PrintReceiptCopy extends Request {
    public PrintReceiptCopy() {
        setOperationCode(OperationsList.PrintReceiptCopy);
        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addOptionalFields(RequestFieldsList.ReceiptReference);
    }
}
