package org.lanter.lan4gate.Messages.Requests.Checkers.SaleOperations;

import org.lanter.lan4gate.Messages.Requests.Checkers.RequestMandatoryFieldsChecker;
import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;

public class SalesCompletion extends RequestMandatoryFieldsChecker {
    public SalesCompletion() {
        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.Amount);
        addMandatoryFields(RequestFieldsList.CurrencyCode);
        addMandatoryFields(RequestFieldsList.TransactionID);
        addMandatoryFields(RequestFieldsList.AuthCode);
        addMandatoryFields(RequestFieldsList.RRN);
    }
}
