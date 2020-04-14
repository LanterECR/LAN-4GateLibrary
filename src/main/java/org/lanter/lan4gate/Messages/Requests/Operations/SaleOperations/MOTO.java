package org.lanter.lan4gate.Messages.Requests.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class MOTO extends Request {
    public MOTO(){
        setOperationCode(OperationsList.MOTO);

        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
    }
}
