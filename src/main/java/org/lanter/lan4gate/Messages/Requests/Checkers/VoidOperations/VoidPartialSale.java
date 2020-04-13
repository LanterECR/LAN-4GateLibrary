package org.lanter.lan4gate.Messages.Requests.Checkers.VoidOperations;

import org.lanter.lan4gate.Messages.Requests.Checkers.RequestMandatoryFieldsChecker;
import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;

public class VoidPartialSale extends RequestMandatoryFieldsChecker {
    public VoidPartialSale() {
        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.ReceiptReference);
    }
}
