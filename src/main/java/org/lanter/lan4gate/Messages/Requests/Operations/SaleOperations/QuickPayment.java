package org.lanter.lan4gate.Messages.Requests.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class QuickPayment extends Request {
    public QuickPayment() {
        setOperationCode(OperationsList.QuickPayment);

        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
    }
}
