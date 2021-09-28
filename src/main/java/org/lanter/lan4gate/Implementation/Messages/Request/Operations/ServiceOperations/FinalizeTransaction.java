package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class FinalizeTransaction extends Request {
    public FinalizeTransaction() {
        setOperationCode(OperationsList.FinalizeTransaction);
        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
    }
}
