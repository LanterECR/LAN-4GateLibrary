package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

public enum ResponseFieldsList {
    /** Логический номер ECR, используемый при взаимодействии с терминалом  */
    EcrNumber ("EcrNumber"),
    /** Логический номер мерчанта в ECR */
    EcrMerchantNumber ("EcrMerchantNumber"),
    /** Код выполняемой операции
     * @see org.lanter.lan4gate.Messages.OperationsList */
    OperationCode ("OperationCode"),
    /** Код ранее выполненной операции. Присутствует в операциях, возвращающих данный по выполненной операции
     * @see org.lanter.lan4gate.Messages.OperationsList */
    OriginalOperationCode ("OriginalOperationCode"),
    /** Итоговая сумма операции. Может отличаться от запрашиваемой и включать значения полей
     * AmountAquirerFee, AmountTerminalFee и TipsAmount
     * @see RequestFieldsList*/
    TotalAmount ("TotalAmount"),
    /** Сумма коммиссии, взимаемой хостом */
    AmountAcquirerFee ("AmountAquirerFee"),
    /** Сумма коммиссии, взимаемой на терминале */
    AmountTerminalFee ("AmountTerminalFee"),
    /** Сумма чаевых */
    TipsAmount ("TipsAmount"),
    /** Код валюты в соответствии с ISO 4217*/
    CurrencyCode ("CurrencyCode"),
    /** Номер чека текущей операции */
    ReceiptReference ("ReceiptReference"),
    /** Номер RRN текущей операции */
    RRN ("RRN"),
    /** Результат выполнения операции. Возможные значения:
     * 1 – успешное выполнение операции;
     * 2 – ошибка выполнения операции;
     * 3 – отказ;
     * 4 – ошибка связи;
     * 5 – операция в состоянии AutoReversal;
     * 6 – данный EcrNumber уже зарегистрирован в LAN-4Gate;
     * 7 – достигнут предел подключений к LAN-4Gate;
     * 8 – чек не найден;
     * 9 – итоги не сошлись;
     * 10 – Нужна сверка итогов;
     * 11 – выполнение прервано в финансовом ПО LAN-4Tap
     * остальное – неизвестная ошибка*/
    Status ("Status"),
    /** Результат ранее выполненной операции.
     * Присутствует в операциях, возвращающих данный по выполненной операции.
     * Значения соответствуют полю Status
     * @see org.lanter.lan4gate.Messages.OperationsList */
    OriginalOperationStatus ("OriginalOperationStatus"),
    /** Время выполнения транзакции по хосту */
    TransDateTime ("TransDateTime"),
    /** Время выполнения транзакции по терминалу*/
    TerminalDateTime ("TerminalDateTime"),
    /** Маскированный PAN карты */
    CardPAN ("CardPAN"),
    /** Срок действия карты */
    ExpireDate ("ExpireDate"),
    /** Имя держателя карты*/
    CardholderName ("CardholderName"),
    /** Метод верификации подлинности держателя карты:
     * 0 – если транзакция не требует верификации;
     * 1 – если вводился пин-код карты;
     * 2 – если надо получить на чеке подпись клиента и проверить ее;
     * 3- если клиент проверился на своем устройстве (телефоне)*/
    CardholderAuthMethod ("CardholderAuthMethod"),
    /** Код авторизации (может возвращаться хостом) */
    AuthCode ("AuthCode"),
    /** Код ответа хоста или терминала*/
    ResponseCode ("ResponseCode"),
    /** Дополнительные данные ответа */
    ResponseText ("ResponseText"),
    /** Внутренний идентификатор транзакции в терминале*/
    STAN ("STAN"),
    /** Идентификатор транзакции на хосте */
    TransactionID ("TransactionID"),
    /** Идентификатор терминала на хосте*/
    TerminalID ("TerminalID"),
    /** Идентификатор приложения карты*/
    CardEmvAid ("CardEmvAid"),
    /** Название приложения карты*/
    CardAppName ("CardAppName"),
    /** Метод обработки карты
     * 1 – ручной ввод в терминале
     * 2 – ручной ввод за пределами терминала
     * 3 – Магнитная полоса
     * 4 – Фолбэк на магнитную полосу
     * 5 – Чип, полная схема
     * 6 – Чип, короткая схема
     * 7 – Бесконтактный ввод. Режим магнитной полосы
     * 8 – Бесконтактный ввод. Режим чипа*/
    CardInputMethod ("CardInputMethod"),
    /** Название платежной системы*/
    IssuerName ("IssuerName"),
    /** Дополнительные данные операции */
    AdditionalInfo ("AdditionalInfo"),
    /** EMV данные карты. Передаются в формате TLV*/
    CardDataEnc ("CardDataEnc"),
    /** Идентификатор мерчанта на хосте*/
    MerchantId ("MerchantId"),
    /** Данные работы с картой*/
    TVR ("TVR"),
    /** Данные работы с картой*/
    TSI ("TSI"),
    /** Данные работы с картой*/
    TC ("TC"),
    /** Данные работы с картой*/
    CID ("CID"),
    /** Данные работы с картой*/
    KVR ("KVR"),
    /** Данные работы с картой*/
    CDAResult ("CDAResult"),
    /** Количество выполненных операций продажи с момента предыдущей сверки итогов
     * Присутствует в операциях PrintDetailReport, PrintSummaryReport и Settlement
     * @see org.lanter.lan4gate.Messages.OperationsList*/
    SalesCount ("SalesCount"),
    /** Количество выполненных операций отмены с момента предыдущей сверки итогов
     * Присутствует в операциях PrintDetailReport, PrintSummaryReport и Settlement
     * @see org.lanter.lan4gate.Messages.OperationsList*/
    VoidCount ("VoidCount"),
    /** Количество выполненных операций возврата с момента предыдущей сверки итогов
     * Присутствует в операциях PrintDetailReport, PrintSummaryReport и Settlement
     * @see org.lanter.lan4gate.Messages.OperationsList*/
    RefundCount ("RefundCount"),
    /** Массив операций оплаты, выполненных с момента предыдущей сверки итогов.
     * Присутствует в операциях DetailReport и Settlement (в случае несовпадения итогов)
     * @see org.lanter.lan4gate.Messages.OperationsList*/
    SalesArray ("SalesArray"),
    /** Массив операций отмены, выполненных с момента предыдущей сверки итогов.
     * Присутствует в операциях DetailReport и Settlement (в случае несовпадения итогов)
     * @see org.lanter.lan4gate.Messages.OperationsList*/
    VoidArray ("VoidArray"),
    /** Массив операций возврата, выполненных с момента предыдущей сверки итогов.
     * Присутствует в операциях DetailReport и Settlement (в случае несовпадения итогов)
     * @see org.lanter.lan4gate.Messages.OperationsList*/
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
