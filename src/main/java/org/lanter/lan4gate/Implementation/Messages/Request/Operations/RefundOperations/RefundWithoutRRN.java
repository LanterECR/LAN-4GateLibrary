package org.lanter.lan4gate.Implementation.Messages.Request.Operations.RefundOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class RefundWithoutRRN extends Request {
    public RefundWithoutRRN() {
        setOperationCode(OperationsList.RefundWithoutRRN);

        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
    }
}
