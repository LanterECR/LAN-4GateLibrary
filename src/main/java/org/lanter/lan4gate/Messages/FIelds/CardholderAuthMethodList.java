package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

/**
 * Перечисение, описывающая способы авторизации держателя карты
 */
public enum CardholderAuthMethodList {
    /**
     * Авторизация не требуется
     */
    NoVerification(0),
    /**
     * Авторизация с помощью пин-кода
     */
    PinVerification(1),
    /**
     * Необходимо получить подпись на чеке
     */
    PaperSignatureVerification(2),
    /**
     * Авторизация на устройстве пользователя, например телефоне
     */
    ClientDeviceVerification(3);

    private final int mOperationValue;
    private final static Map<Integer, CardholderAuthMethodList> mStaticValuesMap = new HashMap<>();

    static {
        for(CardholderAuthMethodList operation : CardholderAuthMethodList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    CardholderAuthMethodList(int value) {
        mOperationValue = value;
    }

    /**
     * Gets value.
     *
     * @param operationValue the operation value
     *
     * @return the value
     */
    public static CardholderAuthMethodList getValue(int operationValue) {
        return mStaticValuesMap.get(operationValue);
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
