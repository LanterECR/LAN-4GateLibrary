package org.lanter.lan4gate.Implementation.Messages.Response.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class QuickPayment extends Response {
    public QuickPayment() {
        setOperationCode(OperationsList.QuickPayment);

        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
        addOptionalFields(ResponseFieldsList.TotalAmount);
        addOptionalFields(ResponseFieldsList.CurrencyCode);
        addOptionalFields(ResponseFieldsList.ReceiptReference);
    }
}
