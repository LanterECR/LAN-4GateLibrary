package org.lanter.lan4gate.Messages.Requests.Checkers.VoidOperations;

import org.lanter.lan4gate.Messages.Requests.Checkers.RequestMandatoryFieldsChecker;
import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;

public class VoidPreAuth extends RequestMandatoryFieldsChecker {
    public VoidPreAuth() {
        addMandatoryFields(RequestFieldsList.EcrMerchantNumber);
        addMandatoryFields(RequestFieldsList.TransactionID);
    }
}
