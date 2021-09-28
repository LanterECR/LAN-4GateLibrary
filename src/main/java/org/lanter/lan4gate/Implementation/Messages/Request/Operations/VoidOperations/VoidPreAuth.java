package org.lanter.lan4gate.Implementation.Messages.Request.Operations.VoidOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class VoidPreAuth extends Request {
    public VoidPreAuth() {
        setOperationCode(OperationsList.VoidPreAuth);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.CardDataEnc);

        addOptionalFields(RequestFieldsList.TransactionID);
    }
}
