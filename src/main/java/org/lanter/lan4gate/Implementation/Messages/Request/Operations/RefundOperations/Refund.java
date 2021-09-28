package org.lanter.lan4gate.Implementation.Messages.Request.Operations.RefundOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class Refund extends Request {
    public Refund() {
        setOperationCode(OperationsList.Refund);

        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addOptionalFields(RequestFieldsList.RRN);
        addOptionalFields(RequestFieldsList.TransactionID);
    }
}
