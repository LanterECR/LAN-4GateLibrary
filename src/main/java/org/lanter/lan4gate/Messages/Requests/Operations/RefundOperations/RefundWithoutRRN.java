package org.lanter.lan4gate.Messages.Requests.Operations.RefundOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class RefundWithoutRRN extends Request {
    public RefundWithoutRRN() {
        setOperationCode(OperationsList.RefundWithoutRRN);

        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
    }
}
