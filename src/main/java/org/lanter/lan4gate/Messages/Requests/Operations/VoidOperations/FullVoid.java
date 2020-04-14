package org.lanter.lan4gate.Messages.Requests.Operations.VoidOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class FullVoid extends Request {
    public FullVoid() {
        setOperationCode(OperationsList.Void);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addOptionalFields(RequestFieldsList.ReceiptReference);
    }
}
