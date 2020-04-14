package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;

import java.util.Set;

public interface IRequest {
    void setEcrNumber(int ecrNumber);
    void setEcrMerchantNumber(int ecrMerchantNumber);
    void setAmount(int amount);
    void setTipsAmount(int tipsAmount);
    void setCashbackAmount(int cashbackAmount);
    void setCurrencyCode(int currencyCode);
    void setRRN(String RRN);
    void setReceiptReference(String receiptReference);
    void setAuthCode(String authCode);
    void setTransactionID(String transactionID);
    void setCardDataEnc(String cardDataEnc);
    void setOpenTags(String openTags);
    void setEncTags(String encTags);
    void setProviderCode(String providerCode);
    void setAdditionalInfo(String additionalInfo);
    Set<RequestFieldsList> getCurrentFields();
    boolean checkMandatoryFields();
}
