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

    void setRRN(String RRN);

    void setReceiptReference(String receiptReference);

    void setAuthCode(String authCode);

    void setTransactionID(String transactionID);

    void setCardDataEnc(String cardDataEnc);

    void setOpenTags(String openTags);

    void setEncTags(String encTags);

    void setProviderCode(String providerCode);

    void setAdditionalInfo(String additionalInfo);

    Set<RequestFieldsList> getCurrentFields();

    boolean checkMandatoryFields();
}
