package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;

import java.util.Set;

/**
 * Интерфейс запроса операции согласно кассового протокола LAN-4Gate
 */
public interface IRequest {
    /**
     * Устанавливает логический номер кассы, используемый при взаимодействии с терминалом
     *
     * @param ecrNumber Целочисленное число, соответствующее логическому номеру кассы
     */
    void setEcrNumber(int ecrNumber);

    /**
     * Логический номер мерчанта в кассе
     *
     * @param ecrMerchantNumber Целое число, соотвествующее логическому номеру мерчанта в кассе
     */
    void setEcrMerchantNumber(int ecrMerchantNumber);

    /**
     * Сумма выполняемой операции
     *
     * @param amount Сумма операции в минимальных единицах используемой валюты. Не более 12 символов
     */
    void setAmount(long amount);

    /**
     * Sets tips amount.
     *
     * @param tipsAmount Сумма операции в минимальных единицах используемой валюты. Не более 12 символов
     */
    void setTipsAmount(long tipsAmount);

    /**
     * Sets cashback amount.
     *
     * @param cashbackAmount Сумма операции в минимальных единицах используемой валюты. Не более 12 символов
     */
    void setCashbackAmount(long cashbackAmount);

    /**
     * Устанавливает код используемой валюты
     *
     * @param currencyCode Код валюты в соответствии с ISO 4217
     */
    void setCurrencyCode(int currencyCode);

    /**
     * Устанавливет RRN, полученный в ранее выполненной финансовой операции
     *
     * @param RRN Строка, содержащая RRN
     */
    void setRRN(String RRN);

    /**
     * Устанавливает номер чека, полученный в ранее выполненной операции.
     *
     * @param receiptReference Строка, содержащая номер чека в терминале
     */
    void setReceiptReference(String receiptReference);

    /**
     * Устанавливет код авторизации, полученный в ранее выполненной финансовой операции
     *
     * @param authCode Строка, содержащая код авторизации
     */
    void setAuthCode(String authCode);

    /**
     * Устанавливет идентификатор транзакции, полученный в ранее выполненной операции
     *
     * @param transactionID Строка, содержащая идентификатор транзакции на хосте
     */
    void setTransactionID(String transactionID);

    /**
     * Устанавливает зашифрованные данные карты, полученный в ранее выполненной операции
     *
     * @param cardDataEnc Строка, содержащая HEX последовательность зашифрованных данных карты
     */
    void setCardDataEnc(String cardDataEnc);

    /**
     * Устанавливает теги, которые необходимо считать в открытом виде для операции FastTrack
     * <br>Каждый тег должен быть 4 байта (8 символов в строке).
     * В случае, если тег меньшей длины, он должен быть дополнен лидирующими нулями до необходимой длины.
     * Теги записываются последовательно в строку
     * <br>Например, теги 9F35 и 50 записываются следующим образом: 0x00009F3500000050
     * <br>Префикс "0X" может быть опущен. Регистр не важен
     *
     * @param openTags Строка, содержащая список открытых тегов
     */
    void setOpenTags(String openTags);

    /**
     * Устанавливает теги, которые необходимо считать в зашифрованном виде для операции FastTrack
     * <br>Каждый тег должен быть 4 байта (8 символов в строке).
     * В случае, если тег меньшей длины, он должен быть дополнен лидирующими нулями до необходимой длины.
     * Теги записываются последовательно в строку
     * <br>Например, теги 9F35 и 50 записываются следующим образом: 0x00009F3500000050
     * <br>Префикс "0X" может быть опущен. Регистр не важен
     * @param encTags Строка, содержащая список зашифрованных тегов
     */
    void setEncTags(String encTags);

    /**
     * Устанавливает код провайдера платежа, полученны при выполнении предыдущей операции
     *
     * @param providerCode Строка, содержащая код провайдера платежа
     */
    void setProviderCode(String providerCode);

    /**
     * Устанавливает дополнительные данные операции. Формат зависит от операции
     *
     * @param additionalInfo Строка, содержащая дополнительные данные операции
     */
    void setAdditionalInfo(String additionalInfo);

    /**
     * Возвращает список установленных полей операции
     *
     * @return Коллекция, содержащая поля операции в соотвествтвии с {@link RequestFieldsList}
     */
    Set<RequestFieldsList> getCurrentFields();

    /**
     * Проверяет все ли обязательные поля операции были установлены
     *
     * @return True, если все обязательные поля операции были установлены
     */
    boolean checkMandatoryFields();
}
