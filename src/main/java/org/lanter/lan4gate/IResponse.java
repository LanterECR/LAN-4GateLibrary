package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.CardInputMethodList;
import org.lanter.lan4gate.Messages.Fields.CardholderAuthMethodList;
import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.Fields.StatusList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

import java.util.Set;

public interface IResponse {
    Set<ResponseFieldsList> getCurrentFieldsList();
    int getEcrNumber();
    int getEcrMerchantNumber();
    OperationsList getOperationCode();
    OperationsList getOriginalOperationCode();
    int getTotalAmount();
    int getAcquirerFeeAmount();
    int getTerminalFeeAmount();
    int getTipsAmount();
    int getCurrencyCode();
    String getReceiptReference();
    String getRRN();
    StatusList getStatus();
    StatusList getOriginalOperationStatus();
    String getTransDateTime();
    String getTerminalDateTime();
    String getCardPAN();
    String getExpireDate();
    String getCardholderName();
    CardholderAuthMethodList getCardholderAuthMethod();
    String getAuthCode();
    String getResponseCode();
    String getResponseText();
    String getSTAN();
    String getTransactionID();
    String getTerminalID();
    String getCardEmvAid();
    String getCardAppName();
    CardInputMethodList getCardInputMethod();
    String getIssuerName();
    String getAdditionalInfo();
    String getCardDataEnc();
    String getMerchantId();
    String getTVR();
    String getTSI();
    String getTC();
    String getCID();
    String getKVR();
    String getCDAResult();
    int getSalesCount();
    int getVoidCount();
    int getRefundCount();
    Set<Response> getSalesArray();
    Set<Response> getVoidArray();
    Set<Response> getRefundArray();
}
