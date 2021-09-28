package org.lanter.lan4gate.Implementation.Messages.Response.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class MOTO extends Response {
    public MOTO(){
        setOperationCode(OperationsList.MOTO);

        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
        addOptionalFields(ResponseFieldsList.TotalAmount);
        addOptionalFields(ResponseFieldsList.CurrencyCode);

        addOptionalFields(ResponseFieldsList.AcquirerFeeAmount);
        addOptionalFields(ResponseFieldsList.TerminalFeeAmount);
        addOptionalFields(ResponseFieldsList.ReceiptReference);
        addOptionalFields(ResponseFieldsList.RRN);
        addOptionalFields(ResponseFieldsList.ResponseCode);
        addOptionalFields(ResponseFieldsList.ResponseText);
        addOptionalFields(ResponseFieldsList.TerminalID);
        addOptionalFields(ResponseFieldsList.MerchantId);
        addOptionalFields(ResponseFieldsList.TransDateTime);
        addOptionalFields(ResponseFieldsList.TerminalDateTime);
        addOptionalFields(ResponseFieldsList.IssuerName);
        addOptionalFields(ResponseFieldsList.CardInputMethod);
        addOptionalFields(ResponseFieldsList.CardPAN);
        addOptionalFields(ResponseFieldsList.ExpireDate);
        addOptionalFields(ResponseFieldsList.CardDataEnc);
        addOptionalFields(ResponseFieldsList.TransactionID);
        addOptionalFields(ResponseFieldsList.CardholderAuthMethod);
        addOptionalFields(ResponseFieldsList.ApplicationLabel);
    }
}
