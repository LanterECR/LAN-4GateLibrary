package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;

import java.util.Set;

/**
 * This interface uses for creating request to terminal.
 */
public interface IRequest {

    /**
     * Sets logical ECR number, that uses for communication.
     *
     * @param ecrNumber Value in range [1, 100]
     */
    void setEcrNumber(int ecrNumber);

    /**
     * Sets logical merchant number, uses by ECR
     *
     * @param ecrMerchantNumber Value in range [0, 99]
     */
    void setEcrMerchantNumber(int ecrMerchantNumber);

    /**
     * Sets amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param amount Value in range [0, 999999999999]
     */
    void setAmount(long amount);

    /**
     * Sets partial amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param amount Value in range [0, 999999999999]
     */
    void setPartialAmount(long amount);
    /**
     * Sets tips amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param tipsAmount Value in range [0, 999999999999]
     */
    void setTipsAmount(long tipsAmount);

    /**
     * Sets cashback amount in minimum currency units, such as penny of ruble.
     * Maximum amount length is 12 digits
     *
     * @param cashbackAmount Value in range [0, 999999999999]
     */
    void setCashbackAmount(long cashbackAmount);

    /**
     * Sets currency code according to ISO 4217
     * For example, russian ruble has 643 code
     * @param currencyCode Value in range [1, 999]
     */
    void setCurrencyCode(int currencyCode);

    /**
     * Sets RRN, that received by one of previous operations.
     *
     * @param RRN String, contains RRN. Max length is 12 symbols
     */
    void setRRN(String RRN);

    /**
     * Sets terminal receipt reference, received by one of previous operations.
     *
     * @param receiptReference String, contains receipt reference.
     */
    void setReceiptReference(String receiptReference);

    /**
     * Sets auth code on host, received by one of previous operations.
     *
     * @param authCode String, contains auth code.
     */
    void setAuthCode(String authCode);

    /**
     * Sets registered on host transaction id, received by one of previous operations.
     *
     * @param transactionID the transaction id
     */
    void setTransactionID(String transactionID);

    /**
     * Sets encryption card data, received by one of previous operations.
     *
     * @param cardDataEnc the card data enc
     */
    void setCardDataEnc(String cardDataEnc);

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
     * Sets the provider of operation code.
     *
     * @param providerCode Max length is 4 symbols
     */
    void setProviderCode(String providerCode);

    /**
     * Sets additional info for operation. Format and length provides by concrete operation. See protocol documentation.
     *
     * @param additionalInfo Max length is 2048 symbols
     */
    void setAdditionalInfo(String additionalInfo);

    /**
     * Gets the list of inserted fields.
     *
     * @return The list of current fields
     */
    Set<RequestFieldsList> getCurrentFields();

    /**
     * Validate mandatory fields for concrete operation. To get mandatory fields, see protocol documentation
     *
     * @return True, if mandatory fields is correct
     */
    boolean checkMandatoryFields();
}
