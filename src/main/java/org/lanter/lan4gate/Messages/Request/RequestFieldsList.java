package org.lanter.lan4gate.Messages.Request;

import java.util.HashMap;
import java.util.Map;

public enum RequestFieldsList {
    EcrNumber ("EcrNumber"),
    EcrMerchantNumber ("EcrMerchantNumber"),
    OperationCode ("OperationCode"),
    Amount ("Amount"),
    PartialAmount ("PartialAmount"),
    TipsAmount ("TipsAmount"),
    CashbackAmount ("CashbackAmount"),
    CurrencyCode ("CurrencyCode"),
    RRN ("RRN"),
    AuthCode ("AuthCode"),
    ReceiptReference ("ReceiptReference"),
    TransactionID ("TransactionID"),
    CardDataEnc ("CardDataEnc"),
    OpenTags ("OpenTags"),
    EncTags ("EncTags"),
    ProviderCode ("ProviderCode"),
    AdditionalInfo ("AdditionalInfo");

    private final String mValue;
    private static final Map<String, RequestFieldsList> mStaticValuesMap = new HashMap<>();

    static {
        for(RequestFieldsList field : RequestFieldsList.values()) {
            mStaticValuesMap.put(field.mValue, field);
        }
    }

    RequestFieldsList(String value) {
        mValue = value;
    }

    public String getString() { return mValue; }
    public static RequestFieldsList getValue (String value) { return mStaticValuesMap.get(value); }
}
