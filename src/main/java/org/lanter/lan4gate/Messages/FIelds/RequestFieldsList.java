package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

/**
 * Список полей запроса
 * @author Lysenkov Vladimir
 */
public enum RequestFieldsList {
    /** Логический номер ECR. Используется при регистрации и взаимодействии с терминалом */
    EcrNumber ("EcrNumber"),
    /** Логический номер мерчанта в ECR */
    EcrMerchantNumber ("EcrMerchantNumber"),
    /** Код выполняемой операции
     * @see org.lanter.lan4gate.Messages.OperationsList */
    OperationCode ("OperationCode"),
    /** Сумма выполняемой операции */
    Amount ("Amount"),
    /** Сумма чаевых */
    TipsAmount ("TipsAmount"),
    /** Сумма кэшбека */
    CashbackAmount ("CashbackAmount"),
    /** Код валюты в соответствии с ISO 4217*/
    CurrencyCode ("CurrencyCode"),
    /** Код RRN, полученный при выполнении одной из предыдущих операций */
    RRN ("RRN"),
    /** Код авторизации на хосте, полученный при выполнении одной из предыдущих операций */
    AuthCode ("AuthCode"),
    /** Номер чека терминала, полученный при выполнении одной из предыдущих операций */
    ReceiptReference ("ReceiptReference"),
    /** Идентификатор транзакции, полученный при выполнении одной из предыдущих операций */
    TransactionID ("TransactionID"),
    /** EMV данные карты, полученный при выполнении одной из предыдущих операций */
    CardDataEnc ("CardDataEnc"),
    /** Список тегов карты, которые необходимо передать в открытом виде запрашиваемых в операции FastTrack.
     * Передаются в формате строки, содержащей шестнадцатеричное число.
     * На каждый тег приходится 4 байта в шестнадцатеричном числе (8 символов в строке).
     * Если длина тега меньше 4 байт, дополняется лидирующими нулями.
     * Например, для тегов 9F35 и 50 формат имеет следующий вид: 0x00009F3500000050*/
    OpenTags ("OpenTags"),
    /** Список тегов карты, которые необходимо передать в зашифрованном виде запрашиваемых в операции FastTrack.
     * Передаются в формате строки, содержащей шестнадцатеричное число.
     * На каждый тег приходится 4 байта в шестнадцатеричном числе (8 символов в строке).
     * Если длина тега меньше 4 байт, дополняется лидирующими нулями.
     * Например, для тегов 9F35 и 50 формат имеет следующий вид: 0x00009F3500000050*/
    EncTags ("EncTags"),
    /** Код вендора(провайдера) платежа */
    ProviderCode ("ProviderCode"),
    /** Дополнительные данные операции*/
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
