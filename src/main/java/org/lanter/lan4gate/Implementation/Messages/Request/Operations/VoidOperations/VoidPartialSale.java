package org.lanter.lan4gate.Implementation.Messages.Request.Operations.VoidOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class VoidPartialSale extends Request {
    public VoidPartialSale() {
        setOperationCode(OperationsList.VoidPartialSale);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.ReceiptReference);

        addOptionalFields(RequestFieldsList.PartialAmount);
        addOptionalFields(RequestFieldsList.CurrencyCode);
    }
}
