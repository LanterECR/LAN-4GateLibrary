package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

/** Перечисления, описывающее возможные статусы выполнения операции */
public enum StatusList {
    /**
     * Неизвестная ошибка
     */
    UnknownError(-1),
    /**
     * Операция выполнена успешно
     */
    Success(1),
    /**
     * Ошибка при выполнении операции
     */
    Error(2),
    /**
     * Операция отклонена
     */
    Decline(3),
    /**
     * Ошибка связи
     */
    CommunicationError(4),
    /**
     * Запрашиваемая операция находится в состоянии автоматической отмены
     */
    OperationIsAutoReversal(5),
    /**
     * Указанный логический идентификатор ECR уже зарегистрирован в шюзе LAN-4Gate
     */
    EcrAlreadyRegistered(6),
    /**
     * Достигнут предел подключений в шлюзе LAN-4Gate
     */
    ConnectionLimitReached(7),
    /**
     * Запрашиваемый чек не найден в журнале терминала
     */
    ReceiptNotFound(8),
    /**
     * Сверка итогов не сошлась
     */
    TotalsNotAgreed(9),
    /**
     * Требуется сверка итогов
     */
    NeedSettlement(10),
    /**
     * Операция отменена терминалом. Например, пользователь отказася от ввода карты.
     */
    CanceledByTerminal(11);

    private final int mOperationValue;
    private final static Map<Integer, StatusList> mStaticValuesMap = new HashMap<>();

    static {
        for(StatusList operation : StatusList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    StatusList(int value) {
        mOperationValue = value;
    }

    /**
     * Gets value.
     *
     * @param operationValue the operation value
     *
     * @return the value
     */
    public static StatusList getValue(int operationValue) {
        StatusList value;
        if(mStaticValuesMap.containsKey(operationValue)) {
            value = mStaticValuesMap.get(operationValue);
        }
        else {
            value = UnknownError;
        }
        return value;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return mOperationValue;
    }
}
