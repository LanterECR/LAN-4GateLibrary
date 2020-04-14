package org.lanter.lan4gate.Messages.Requests.Operations.VoidOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class VoidPartialSale extends Request {
    public VoidPartialSale() {
        setOperationCode(OperationsList.VoidPartialSale);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.ReceiptReference);

        addOptionalFields(RequestFieldsList.Amount);
        addOptionalFields(RequestFieldsList.CurrencyCode);
    }
}
