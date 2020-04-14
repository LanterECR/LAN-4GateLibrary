package org.lanter.lan4gate.Messages.Requests.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class SalesCompletion extends Request {
    public SalesCompletion() {
        setOperationCode(OperationsList.SalesCompletion);

        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
        addMandatoryFields(RequestFieldsList.TransactionID);

        addOptionalFields(RequestFieldsList.AuthCode);
        addOptionalFields(RequestFieldsList.RRN);
        addOptionalFields(RequestFieldsList.CardDataEnc);
    }
}
