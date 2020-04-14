package org.lanter.lan4gate.Messages.Fields;

import java.util.HashMap;
import java.util.Map;

/**
 * Перечисление, содержащее способы ввода карты
 */
public enum CardInputMethodList {
    /**
     * Данные карты введены вручную в терминале
     */
    TerminalManualEntry(1),
    /**
     * Данные карты введены вручную за пределами терминала
     */
    ExternalManualEntry(2),
    /**
     * Используется магнитная полоса
     */
    MagStrip(3),
    /**
     * Произошел фолбэк с чипа на магнитную полосу
     */
    MagStripFallback(4),
    /**
     * Использовался чип. Работа с картой по полной схеме
     */
    ChipFullGrade(5),
    /**
     * Использовался чип. Работа с картой по сокращенной схеме
     */
    ChipPartialGrade(6),
    /**
     * Использовался бесконтактный интерфейс в режиме эмуляции магнитной полосы
     */
    ContactlessMagStripMode(7),
    /**
     * Использовался бексонтактный интерфейс в режиме эмуляции чипа
     */
    ContactlessChipMode(8);

    private final int mOperationValue;
    private final static Map<Integer, CardInputMethodList> mStaticValuesMap = new HashMap<>();

    static {
        for(CardInputMethodList operation : CardInputMethodList.values()) {
            mStaticValuesMap.put(operation.mOperationValue, operation);
        }
    }

    CardInputMethodList(int value) {
        mOperationValue = value;
    }

    /**
     * Gets value.
     *
     * @param operationValue the operation value
     *
     * @return the value
     */
    public static CardInputMethodList getValue(int operationValue) {
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
