package org.lanter.lan4gate.Messages.Requests.Operations.VoidOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class VoidPreAuth extends Request {
    public VoidPreAuth() {
        setOperationCode(OperationsList.VoidPreAuth);

        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.CardDataEnc);

        addOptionalFields(RequestFieldsList.TransactionID);
    }
}
