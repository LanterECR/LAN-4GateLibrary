package org.lanter.lan4gate.Implementation.Messages.Response.Operations.SaleOperations;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class FastTrack extends Response {
    public FastTrack() {
        setOperationCode(OperationsList.FastTrack);

        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
        addOptionalFields(ResponseFieldsList.TotalAmount);
        addOptionalFields(ResponseFieldsList.CurrencyCode);

        addOptionalFields(ResponseFieldsList.TerminalFeeAmount);
        addOptionalFields(ResponseFieldsList.TerminalID);
        addOptionalFields(ResponseFieldsList.MerchantId);
        addOptionalFields(ResponseFieldsList.TerminalDateTime);
        addOptionalFields(ResponseFieldsList.IssuerName);
        addOptionalFields(ResponseFieldsList.CardInputMethod);
        addOptionalFields(ResponseFieldsList.CardPAN);
        addOptionalFields(ResponseFieldsList.CardPANHash);
        addOptionalFields(ResponseFieldsList.ExpireDate);
        addOptionalFields(ResponseFieldsList.CardAppName);
        addOptionalFields(ResponseFieldsList.CardEmvAid);
        addOptionalFields(ResponseFieldsList.CardDataEnc);
        addOptionalFields(ResponseFieldsList.CardholderName);
        addOptionalFields(ResponseFieldsList.CardholderAuthMethod);
        addOptionalFields(ResponseFieldsList.ApplicationLabel);
    }
}
