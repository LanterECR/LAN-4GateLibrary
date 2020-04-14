package org.lanter.lan4gate.Messages.Requests.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class FastTrack extends Request {
    public FastTrack() {
        setOperationCode(OperationsList.FastTrack);
        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
        addMandatoryFields(RequestFieldsList.OpenTags);

        addOptionalFields(RequestFieldsList.EncTags);
    }
}
