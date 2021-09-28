package org.lanter.lan4gate.Implementation.Messages.Request.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class SalesCompletion extends Request {
    public SalesCompletion() {
        setOperationCode(OperationsList.SalesCompletion);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
        addMandatoryFields(RequestFieldsList.TransactionID);

        addOptionalFields(RequestFieldsList.AuthCode);
        addOptionalFields(RequestFieldsList.RRN);
        addOptionalFields(RequestFieldsList.CardDataEnc);
    }
}
