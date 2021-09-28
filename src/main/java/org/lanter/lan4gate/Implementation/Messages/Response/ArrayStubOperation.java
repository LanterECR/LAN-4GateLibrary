package org.lanter.lan4gate.Implementation.Messages.Response;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;

public class ArrayStubOperation extends Response {
    public ArrayStubOperation() {
        clearMandatoryFields();
        clearOptionalFields();

        addMandatoryFields(ResponseFieldsList.TotalAmount);
        addMandatoryFields(ResponseFieldsList.CurrencyCode);
        addMandatoryFields(ResponseFieldsList.RRN);
        addMandatoryFields(ResponseFieldsList.ReceiptReference);
        addMandatoryFields(ResponseFieldsList.ResponseCode);
        addMandatoryFields(ResponseFieldsList.TransactionID);
        addMandatoryFields(ResponseFieldsList.TransDateTime);
        addMandatoryFields(ResponseFieldsList.CardPAN);
    }
}
