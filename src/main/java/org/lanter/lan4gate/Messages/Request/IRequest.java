package org.lanter.lan4gate.Messages.Request;

import org.lanter.lan4gate.Messages.OperationsList;

import java.util.Set;

/**
 * This interface uses for creating request to terminal.
 */
public interface IRequest {

    /**
     * Gets the list of mandatory fields for operation
     * @return The list of mandatory fields
     */
    Set<RequestFieldsList> getMandatoryFields();

    /**
     * Gets the list of optional fields for operation
     * @return The list of optional fields
     */
    Set<RequestFieldsList> getOptionalFields();

    /**
     * Gets the list of inserted fields.
     *
     * @return The list of current fields
     */
    Set<RequestFieldsList> getCurrentFields();

    /**
     * Gets current operation code
     *
     * @return Value from {@link OperationsList}. If field doesn`t set, returns NoOperation
     */
    OperationsList getOperationCode();

    /**
     * Gets logical ECR number
     *
     * @return -1, if field doesn`t set
     */
    int getEcrNumber();

    /**
     * Sets logical ECR number, that uses for communication.
     *
     * @param ecrNumber Value in range [1, 100]
     */
    void setEcrNumber(int ecrNumber);

    /**
     * Gets logical merchant number, uses by ECR
     *
     * @return -1, if field doesn`t set
     */
    int getEcrMerchantNumber();

    /**
     * Sets logical merchant number, uses by ECR
     *
     * @param ecrMerchantNumber Value in range [0, 99]
     */
    void setEcrMerchantNumber(int ecrMerchantNumber);

    /**
     * Gets amount.
     *
     * @return the amount
     */
    long getAmount();

    /**
     * Sets amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param amount Value in range [0, 999999999999]
     */
    void setAmount(long amount);

    /**
     * Gets partial amount.
     *
     * @return the partial amount
     */
    long getPartialAmount();

    /**
     * Sets partial amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param amount Value in range [0, 999999999999]
     */
    void setPartialAmount(long amount);

    /**
     * Gets tips amount.
     *
     * @return the tips amount
     */
    long getTipsAmount();

    /**
     * Sets tips amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param tipsAmount Value in range [0, 999999999999]
     */
    void setTipsAmount(long tipsAmount);

    /**
     * Gets cashback amount.
     *
     * @return the cashback amount
     */
    long getCashbackAmount();

    /**
     * Sets cashback amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param cashbackAmount Value in range [0, 999999999999]
     */
    void setCashbackAmount(long cashbackAmount);

    /**
     * Gets currency code.
     *
     * @return the currency code
     */
    int getCurrencyCode();

    /**
     * Sets currency code according to ISO 4217
     * For example, russian ruble has 643 code
     * @param currencyCode Value in range [1, 999]
     */
    void setCurrencyCode(int currencyCode);

    /**
     * Gets RRN, that received by one of previous operations.
     *
     * @return empty string, if field doesn`t set
     */
    String getRRN();

    /**
     * Sets RRN, that received by one of previous operations.
     *
     * @param RRN String, contains RRN. Max length is 12 symbols
     */
    void setRRN(String RRN);

    /**
     * Gets receipt reference.
     *
     * @return empty string, if field doesn`t set
     */
    String getReceiptReference();

    /**
     * Sets terminal receipt reference, received by one of previous operations.
     *
     * @param receiptReference String, contains receipt reference.
     */
    void setReceiptReference(String receiptReference);

    /**
     * Gets auth code.
     *
     * @return empty string, if field doesn`t set
     */
    String getAuthCode();

    /**
     * Sets auth code on host, received by one of previous operations.
     *
     * @param authCode String, contains auth code.
     */
    void setAuthCode(String authCode);

    /**
     * Gets transaction id.
     *
     * @return empty string, if field doesn`t set
     */
    String getTransactionID();

    /**
     * Sets registered on host transaction id, received by one of previous operations.
     *
     * @param transactionID the transaction id
     */
    void setTransactionID(String transactionID);

    /**
     * Gets card data enc.
     *
     * @return empty string, if field doesn`t set
     */
    String getCardDataEnc();

    /**
     * Sets encryption card data, received by one of previous operations.
     *
     * @param cardDataEnc the card data enc
     */
    void setCardDataEnc(String cardDataEnc);

    /**
     * Gets open tags.
     *
     * @return empty string, if field doesn't set
     */
    String getOpenTags();

    /**
     * Sets the list of EMV tags for Fast track operation, that must be returned to ECR in raw TLV view without encryption.
     *
     * @param openTags The string formatted by next pattern: Every tag must be coded by 4 byte on text hex view.
     *                 For the example, tag DF82 looks like as 0000DF82 and tag 82 looks like 00000082.
     *                 Multiple tags writes as 0000DF8200000082.
     *                 This string may be begun from 0x prefix.
     *                 Case type may be any.
     */
    void setOpenTags(String openTags);

    /**
     * Gets enc tags.
     *
     * @return empty string, if field doesn`t set
     */
    String getEncTags();

    /**
     * Sets the list of EMV tags for Fast track operation, that must be returned to ECR in encrypted TLV view.
     *
     * @param encTags The string formatted by next pattern: Every tag must be coded by 4 byte on text hex view.
     *                For the example, tag DF82 looks like as 0000DF82 and tag 82 looks like 00000082.
     *                Multiple tags writes as 0000DF8200000082.
     *                This string may be begun from 0x prefix.
     *                Case type may be any.
     */
    void setEncTags(String encTags);

    /**
     * Gets provider code.
     *
     * @return empty string, if field doesn`t set
     */
    String getProviderCode();

    /**
     * Sets the provider of operation code.
     *
     * @param providerCode Max length is 4 symbols
     */
    void setProviderCode(String providerCode);

    /**
     * Gets additional info for operation. Format and length provides by concrete operation. See protocol documentation.
     *
     * @return empty string, if field doesn`t set
     */
    String getAdditionalInfo();

    /**
     * Sets additional info for operation. Format and length provides by concrete operation. See protocol documentation.
     *
     * @param additionalInfo Max length is 2048 symbols
     */
    void setAdditionalInfo(String additionalInfo);

    /**
     * Validate mandatory fields for concrete operation. To get mandatory fields, see protocol documentation
     *
     * @return True, if mandatory fields is correct
     */
    boolean checkMandatoryFields();
}
