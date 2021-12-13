package org.lanter.lan4gate.Messages.Response;

import java.util.HashMap;
import java.util.Map;

public enum ResponseFieldsList {
    EcrNumber ("EcrNumber"),
    EcrMerchantNumber ("EcrMerchantNumber"),
    OperationCode ("OperationCode"),
    OriginalOperationCode ("OriginalOperationCode"),
    TotalAmount ("TotalAmount"),
    PartialAmount("PartialAmount"),
    AcquirerFeeAmount("AmountAquirerFee"),
    TerminalFeeAmount("AmountTerminalFee"),
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
    CardData ("CardData"),
    CardDataEnc ("CardDataEnc"),
    MerchantId ("MerchantId"),
    TVR ("TVR"),
    TSI ("TSI"),
    TC ("TC"),
    CID ("CID"),
    KVR ("KVR"),
    CDAResult ("CDAResult"),
    SalesAmount ("SalesAmount"),
    VoidAmount ("VoidAmount"),
    RefundAmount ("RefundAmount"),
    SalesCount ("SalesCount"),
    VoidCount ("VoidCount"),
    RefundCount ("RefundCount"),
    SalesArray ("SalesArray"),
    VoidArray ("VoidArray"),
    RefundArray ("RefundArray"),
    CardPANHash ("CardPANHash"),
    ReceiptLine1("receiptLine1"),
    ReceiptLine2("receiptLine2"),
    ReceiptLine3("receiptLine3"),
    ReceiptLine4("receiptLine4"),
    ReceiptLine5("receiptLine5"),
    FinalizationRequired("FinalizationRequired"),
    ApplicationLabel("ApplicationLabel");

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
