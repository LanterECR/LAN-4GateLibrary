package org.lanter.lan4gate.Messages.Responses.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

public class QuickPayment extends Response {
    public QuickPayment() {
        setOperationCode(OperationsList.QuickPayment);

        addMandatoryFields(ResponseFieldsList.EcrMerchantNumber);
        addMandatoryFields(ResponseFieldsList.TotalAmount);
        addMandatoryFields(ResponseFieldsList.CurrencyCode);
    }
}
