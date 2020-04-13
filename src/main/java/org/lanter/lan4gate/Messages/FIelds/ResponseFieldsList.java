package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

public enum ResponseFieldsList {
    EcrNumber ("EcrNumber"),
    EcrMerchantNumber ("EcrMerchantNumber"),
    OperationCode ("OperationCode"),
    OriginalOperationCode ("OriginalOperationCode"),
    TotalAmount ("TotalAmount"),
    AmountAcquirerFee ("AmountAquirerFee"),
    AmountTerminalFee ("AmountTerminalFee"),
    TipsAmount ("TipsAmount"),
    CurrencyCode ("CurrencyCode"),
    ReceiptReference ("ReceiptReference"),
    RRN ("RRN"),
    Status ("Status"),
    OriginalOperationStatus ("OriginalOperationStatus"),
    TransDateTime ("TransDateTime"),
    TerminalDateTime ("TerminalDateTime"),
    CardPAN ("CardPAN"),
    ExpireDate ("ExpireDate"),
    CardholderName ("CardholderName"),
    CardholderAuthMethod ("CardholderAuthMethod"),
    AuthCode ("AuthCode"),
    ResponseCode ("ResponseCode"),
    ResponseText ("ResponseText"),
    STAN ("STAN"),
    TransactionID ("TransactionID"),
    TerminalID ("TerminalID"),
    CardEmvAid ("CardEmvAid"),
    CardAppName ("CardAppName"),
    CardInputMethod ("CardInputMethod"),
    IssuerName ("IssuerName"),
    AdditionalInfo ("AdditionalInfo"),
    CardDataEnc ("CardDataEnc"),
    MerchantId ("MerchantId"),
    TVR ("TVR"),
    TSI ("TSI"),
    TC ("TC"),
    CID ("CID"),
    KVR ("KVR"),
    CDAResult ("CDAResult"),
    SalesCount ("SalesCount"),
    VoidCount ("VoidCount"),
    RefundCount ("RefundCount"),
    SalesArray ("SalesArray"),
    VoidArray ("VoidArray"),
    RefundArray ("RefundArray");

    private final String mValue;
    private static final Map<String, ResponseFieldsList> mStaticValuesMap = new HashMap<>();

    static {
        for(ResponseFieldsList field : ResponseFieldsList.values()) {
            mStaticValuesMap.put(field.mValue, field);
        }
    }

    ResponseFieldsList(String value) {
        mValue = value;
    }

    public String getString() { return mValue; }
    public static ResponseFieldsList getValue (String value) { return mStaticValuesMap.get(value); }
}
