package org.lanter.lan4gate.Messages.Requests.Checkers.SaleOperations;

import org.lanter.lan4gate.Messages.Requests.Checkers.RequestMandatoryFieldsChecker;
import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;

public class FastTrack extends RequestMandatoryFieldsChecker {
    public FastTrack() {
        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
        addMandatoryFields(RequestFieldsList.OpenTags);
    }
}
