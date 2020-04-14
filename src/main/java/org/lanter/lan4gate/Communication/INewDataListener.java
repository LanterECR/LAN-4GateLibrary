package org.lanter.lan4gate.Communication;

/**
 * Интерфейс для получения уведомлений о новыйх данных из сети
 */
public interface INewDataListener {
    /**
     * Метод, в который будут переданы новые данные из сети
     *
     * @param data Строка в кодировке UTF-8
     */
    void newData(String data);
}
