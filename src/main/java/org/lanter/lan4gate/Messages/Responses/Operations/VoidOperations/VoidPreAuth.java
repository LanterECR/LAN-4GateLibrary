package org.lanter.lan4gate.Messages.Responses.Operations.VoidOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

public class VoidPreAuth extends Response {
    public VoidPreAuth() {
        setOperationCode(OperationsList.VoidPreAuth);

        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
        addMandatoryFields(ResponseFieldsList.Status);
        addMandatoryFields(ResponseFieldsList.TotalAmount);
        addMandatoryFields(ResponseFieldsList.CurrencyCode);

        addOptionalFields(ResponseFieldsList.AcquirerFeeAmount);
        addOptionalFields(ResponseFieldsList.RRN);
        addOptionalFields(ResponseFieldsList.ResponseCode);
        addOptionalFields(ResponseFieldsList.ResponseText);
        addOptionalFields(ResponseFieldsList.AuthCode);
        addOptionalFields(ResponseFieldsList.TerminalID);
        addOptionalFields(ResponseFieldsList.MerchantId);
        addOptionalFields(ResponseFieldsList.TransDateTime);
        addOptionalFields(ResponseFieldsList.TerminalDateTime);
        addOptionalFields(ResponseFieldsList.IssuerName);
        addOptionalFields(ResponseFieldsList.CardInputMethod);
        addOptionalFields(ResponseFieldsList.CardPAN);
        addOptionalFields(ResponseFieldsList.ExpireDate);
        addOptionalFields(ResponseFieldsList.CardAppName);
        addOptionalFields(ResponseFieldsList.CardEmvAid);
        addOptionalFields(ResponseFieldsList.CardDataEnc);
        addOptionalFields(ResponseFieldsList.TVR);
        addOptionalFields(ResponseFieldsList.TSI);
        addOptionalFields(ResponseFieldsList.TC);
        addOptionalFields(ResponseFieldsList.CID);
        addOptionalFields(ResponseFieldsList.KVR);
        addOptionalFields(ResponseFieldsList.CDAResult);
        addOptionalFields(ResponseFieldsList.TransactionID);
        addOptionalFields(ResponseFieldsList.CardholderName);
        addOptionalFields(ResponseFieldsList.CardholderAuthMethod);
    }
}
