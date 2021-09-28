package org.lanter.lan4gate.Implementation.Messages.Request.Operations.VoidOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class FullVoid extends Request {
    public FullVoid() {
        setOperationCode(OperationsList.Void);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addOptionalFields(RequestFieldsList.ReceiptReference);
    }
}
