package org.lanter.lan4gate.Messages;

import java.util.HashMap;
import java.util.Map;

/**
 * Список поддерживаемых операций
 * @author Lysenkov Vladimir
 */
public enum OperationsList {
    NoOperation(-1),
    //Операции оплаты
    /** Продажа */
    Sale (1),
    /** Mail order/telephone oreder - заказ по e-mail или телефону */
    MOTO (2),
    /** Оплата через систему быстрых платежей */
    QuickPayment (3),
    /** Преавторизация */
    PreAuth (200),
    /** Расчёт */
    SalesCompletion (201),
    /** Получение тегов карты */
    FastTrack (300),

    //Операции отмены
    /** Отмена продажи */
    Void (400),
    /** Частичная отмена продажи */
    VoidPartialSale (401),
    /** Отмена преавторизации */
    VoidPreAuth (402),

    //Операции возврата
    /** Возврат с использованием RRN */
    Refund (500),
    /** Возврат без использования RRN*/
    RefundWithoutRRN (501),

    //Сервисные операции
    /** Выполнение регистрации в транспортном сервисе LAN-4Gate */
    Registration (800),
    /** Проверка связи с терминалом */
    TestCommunication (801),
    /** Проверка связи терминала с хостом*/
    Test (802),
    /** Печать последнего чека и получение данных */
    PrintLastReceipt (803),
    /** Получение данных последнего чека без печати */
    GetLastOperation (804),
    /** Печати копии чека по номеру */
    PrintReceiptCopy (805),
    /** Печать детального отчета и получение данных отчета */
    PrintDetailReport (806),
    /** Печать краткого отчетка и получение данных отчета */
    PrintSummaryReport (807),
    /** Запуск сверки итогов и получение результатов полного или краткого отчета*/
    Settlement (808),
    /** Загрузка ключей с хоста */
    KeyDownload (809),
    /** Загрузка параметров терминала*/
    Initialization (810),
    /** Загрузка ПО терминала */
    UpdateSW (811),
    /** Печать сведений о настроенных коммуникациях терминала */
    PrintCommsInfo (812),
    /** Печать сведений о ПО терминала */
    PrintSoftInfo (813),
    /** Команда на завершение текущей финансовой операции */
    FinalizeTransaction (814),
    /** Получение сведений о используемом устройстве печати - терминал или ECR*/
    GetCurrentPrinter (815),
    /** Установка текущего используемого устройства печати - терминал или ECR*/
    SetCurrentPrinter (816),
    /** Самопроверка терминала  */
    SelfTest(817);

    private final int mOperationValue;
    private final static Map<Integer, OperationsList> mStaticValuesMap = new HashMap<>();

    static {
        for(OperationsList operation : OperationsList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    OperationsList(int value) {
        mOperationValue = value;
    }
    public static OperationsList getValue(int operationValue) {
        return mStaticValuesMap.get(operationValue);
    }
    public int getNumber() {
        return mOperationValue;
    }
}
