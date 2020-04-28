package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.*;
import org.lanter.lan4gate.Messages.OperationsList;

import java.util.Map;
import java.util.Set;

public interface IResponse {

    Set<ResponseFieldsList> getCurrentFieldsList();
    Map<ResponseFieldsList, String> packAsString();
    Map<ResponseFieldsList, Object> packAsObject();
    int getEcrNumber();

    int getEcrMerchantNumber();

    OperationsList getOperationCode();

    OperationsList getOriginalOperationCode();

    long getTotalAmount();

    long getAcquirerFeeAmount();

    long getTerminalFeeAmount();

    long getTipsAmount();

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

    Set<IResponse> getSalesArray();

    Set<IResponse> getVoidArray();

    Set<IResponse> getRefundArray();
}
