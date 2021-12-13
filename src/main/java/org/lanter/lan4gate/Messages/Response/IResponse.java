package org.lanter.lan4gate.Messages.Response;

import org.lanter.lan4gate.Messages.OperationsList;

import java.util.Map;
import java.util.Set;

/**
 * This interface provide access for response data from terminal
 */
public interface IResponse {

    /**
     * Gets current fields list. Contains all received fields according to {@link ResponseFieldsList}
     *
     * @return the current fields list
     */
    Set<ResponseFieldsList> getMandatoryFields();

    /**
     * Gets current fields list. Contains all received fields according to {@link ResponseFieldsList}
     *
     * @return the current fields list
     */
    Set<ResponseFieldsList> getOptionalFields();

    /**
     * Gets current fields list. Contains all received fields according to {@link ResponseFieldsList}
     *
     * @return the current fields list
     */
    Set<ResponseFieldsList> getCurrentFieldsList();

    /**
     * Validate mandatory fields for concrete operation. To get mandatory fields, see protocol documentation
     *
     * @return True, if mandatory fields is correct
     */
    boolean checkMandatoryFields();

    /**
     * Packed all received fields into string. Exclude all arrays.
     * All enum in first transform into their storage type, such as String, int, etc. After writes into String
     * To get arrays info, you must call this method on every array element.
     * @return The map, contains pairs of {@link ResponseFieldsList} and String-view of field
     */
    Map<ResponseFieldsList, String> packAsString();

    /**
     * Packed all received fields into object.
     * All fields writes into map as-is, cast to Object.
     * For example, arrays will be write as Set {@link IResponse} . Primitive types writes as wrappers.
     * For access to field data you mast cast their type
     *
     * @return the map, contains pairs of {@link ResponseFieldsList} and casted to Object fields.
     */
    Map<ResponseFieldsList, Object> packAsObject();

    /**
     * Returns logical ECR number, that terminal received in request.
     * You must compare this field with you value.
     *
     * @return Logical ECR number
     */
    int getEcrNumber();

    /**
     * Sets ecr number.
     *
     * @param ecrNumber the ecr number
     */
    void setEcrNumber(int ecrNumber);

    /**
     * Returns logical ECR merchant number, that terminal received in request.
     *
     * @return Logical ECR number
     */
    int getEcrMerchantNumber();

    /**
     * Sets ecr merchant number.
     *
     * @param ecrMerchantNumber the ecr merchant number
     */
    void setEcrMerchantNumber(int ecrMerchantNumber);

    /**
     * Returns executed operation code.
     *
     * @return One of {@link OperationsList} enum values
     */
    OperationsList getOperationCode();

    /**
     * Sets operation code.
     *
     * @param operationCode the operation code
     */
    void setOperationCode(OperationsList operationCode);

    /**
     * Returns operation code for original operation. Relevant for operations same as PrintReceiptCopy.
     *
     * @return One of {@link OperationsList} enum values
     */
    OperationsList getOriginalOperationCode();

    /**
     * Sets original operation code.
     *
     * @param originalOperationCode the original operation code
     */
    void setOriginalOperationCode(OperationsList originalOperationCode);

    /**
     * Returns total amount in minimum currency units for executed operation.
     * Value is sum of amount from request, acquirer fee, terminal fee and tips amount
     *
     * @return Value in range [0, 999999999999]
     */
    long getTotalAmount();

    /**
     * Sets total amount.
     *
     * @param totalAmount the total amount
     */
    void setTotalAmount(long totalAmount);

    /**
     * Returns partial amount in minimum currency units for executed operation.
     * Value is sum of amount from request, acquirer fee, terminal fee and tips amount
     *
     * @return Value in range [0, 999999999999]
     */
    long getPartialAmount();

    /**
     * Sets partial amount.
     *
     * @param partialAmount the partial amount
     */
    void setPartialAmount(long partialAmount);

    /**
     * Returns acquirer fee amount in minimum currency units for executed operation.
     *
     * @return Value in range [0, 999999999999]
     */
    long getAcquirerFeeAmount();

    /**
     * Sets acquirer fee amount.
     *
     * @param amountAcquirerFee the amount acquirer fee
     */
    void setAcquirerFeeAmount(long amountAcquirerFee);

    /**
     * Returns the terminal fee amount in minimum currency units for executed operation.
     *
     * @return Value in range [0, 999999999999]
     */
    long getTerminalFeeAmount();

    /**
     * Sets terminal fee amount.
     *
     * @param amountTerminalFee the amount terminal fee
     */
    void setTerminalFeeAmount(long amountTerminalFee);

    /**
     * Returns tips amount in minimum currency units for executed operation.
     *
     * @return Value in range [0, 999999999999]
     */
    long getTipsAmount();

    /**
     * Sets tips amount.
     *
     * @param tipsAmount the tips amount
     */
    void setTipsAmount(long tipsAmount);

    /**
     * Gets currency code.
     *
     * @return the currency code
     */
    int getCurrencyCode();

    /**
     * Sets currency code.
     *
     * @param currencyCode the currency code
     */
    void setCurrencyCode(int currencyCode);

    /**
     * Returns currency code according to ISO 4217 for executed operation.
     * For example, russian ruble has 643 code
     *
     * @return  Value in range [1, 999]
     */
    String getReceiptReference();

    /**
     * Sets receipt reference.
     *
     * @param receiptReference the receipt reference
     */
    void setReceiptReference(String receiptReference);

    /**
     * Return RRN code for executed operation.
     *
     * @return the rrn
     */
    String getRRN();

    /**
     * Sets rrn.
     *
     * @param RRN the rrn
     */
    void setRRN(String RRN);

    /**
     * Return result status for executed operation.
     *
     * @return One of {@link StatusList} enum values.
     */
    StatusList getStatus();

    /**
     * Sets status.
     *
     * @param status the status
     */
    void setStatus(StatusList status);

    /**
     * Returns result status for original operation. Relevant for operations same as PrintReceiptCopy.
     *
     * @return One of {@link StatusList} enum values.
     */
    StatusList getOriginalOperationStatus();

    /**
     * Sets original operation status.
     *
     * @param originalOperationStatus the original operation status
     */
    void setOriginalOperationStatus(StatusList originalOperationStatus);

    /**
     * Returns date and time from host, when operation was executed.
     *
     * @return String in host format. Usually is "YYYYMMDDHHMMSS"
     */
    String getTransDateTime();

    /**
     * Sets date and time from host, when operation was executed.
     *
     * @param transDateTime String in host format. Usually is "YYYYMMDDHHMMSS"
     */
    void setTransDateTime(String transDateTime);

    /**
     * Returns date and time from terminal, when operation was executed.
     *
     * @return String in format "YYYYMMDDHHMMSS"
     */
    String getTerminalDateTime();

    /**
     * Sets date and time from terminal, when operation was executed.
     *
     * @param terminalDateTime String in format "YYYYMMDDHHMMSS"
     */
    void setTerminalDateTime(String terminalDateTime);

    /**
     * Return masked card PAN
     *
     * @return String, contains masked by asterisk card PAN
     */
    String getCardPAN();

    /**
     * Sets masked card PAN
     *
     * @param cardPAN String, contains masked by asterisk card PAN
     */
    void setCardPAN(String cardPAN);

    /**
     * Returns card expire date
     *
     * @return String in format "YYMM"
     */
    String getExpireDate();

    /**
     * Sets card expire date
     *
     * @param expireDate String in format "YYMM"
     */
    void setExpireDate(String expireDate);

    /**
     * Return cardholder name
     *
     * @return String, contains cardholder name
     */
    String getCardholderName();

    /**
     * Sets cardholder name.
     *
     * @param cardholderName the cardholder name
     */
    void setCardholderName(String cardholderName);

    /**
     * Returns cardholder auth method, that used in operation processing
     *
     * @return On of {@link CardholderAuthMethodList} enum values.
     */
    CardholderAuthMethodList getCardholderAuthMethod();

    /**
     * Sets cardholder auth method, that used in operation processing
     *
     * @param cardholderAuthMethod one of {@link CardholderAuthMethodList}
     */
    void setCardholderAuthMethod(CardholderAuthMethodList cardholderAuthMethod);

    /**
     * Returns auth code from host
     *
     * @return String contains auth code in host format
     */
    String getAuthCode();

    /**
     * Sets auth code from host
     *
     * @param authCode the auth code
     */
    void setAuthCode(String authCode);

    /**
     * Returns response code from host
     *
     * @return String contains response code in host format
     */
    String getResponseCode();

    /**
     * Sets response code.
     *
     * @param responseCode the response code
     */
    void setResponseCode(String responseCode);

    /**
     * Returns response text from host or terminal
     *
     * @return String, contains response text in UTF-8. May contains russian language.
     */
    String getResponseText();

    /**
     * Sets response text.
     *
     * @param responseText the response text
     */
    void setResponseText(String responseText);

    /**
     * Returns terminal transaction ID
     *
     * @return String, contains terminal transaction ID
     */
    String getSTAN();

    /**
     * Sets terminal transaction ID
     *
     * @param STAN String, contains terminal transaction ID
     */
    void setSTAN(String STAN);

    /**
     * Returns host transaction ID
     *
     * @return String, contains host transaction ID
     */
    String getTransactionID();

    /**
     * Sets transaction id.
     *
     * @param transactionID the transaction id
     */
    void setTransactionID(String transactionID);

    /**
     * Returns terminal ID registered on host
     *
     * @return String, contains terminal ID registered on host
     */
    String getTerminalID();

    /**
     * Sets terminal id.
     *
     * @param terminalID the terminal id
     */
    void setTerminalID(String terminalID);

    /**
     * Returns card EMV application ID.
     *
     * @return String contains card EMV application ID.
     */
    String getCardEmvAid();

    /**
     * Sets card emv aid.
     *
     * @param cardEmvAid the card emv aid
     */
    void setCardEmvAid(String cardEmvAid);

    /**
     * Returns card application name.
     *
     * @return String contains card application name
     */
    String getCardAppName();

    /**
     * Sets card app name.
     *
     * @param cardAppName the card app name
     */
    void setCardAppName(String cardAppName);

    /**
     * Returns card input method, that used in operation processing
     *
     * @return One of {@link CardInputMethodList} enum values.
     */
    CardInputMethodList getCardInputMethod();

    /**
     * Sets card input method.
     *
     * @param cardInputMethod the card input method
     */
    void setCardInputMethod(CardInputMethodList cardInputMethod);

    /**
     * Returns issuer name.
     *
     * @return the issuer name
     */
    String getIssuerName();

    /**
     * Sets issuer name.
     *
     * @param issuerName the issuer name
     */
    void setIssuerName(String issuerName);

    /**
     * Returns additional info for executed operation.
     *
     * @return Format, length and type provides by concrete operations. See protocol documentation
     */
    String getAdditionalInfo();

    /**
     * Set additional info.
     *
     * @param additionalInfo the additional info
     */
    void setAdditionalInfo(String additionalInfo);

    /**
     * Returns non encrypted tags for operation Fast track
     *
     * @return String contains text hex value in TLV format, starts by 0x sequence. Case may be any
     */
    String getCardData();

    /**
     * Sets card data.
     *
     * @param cardData the card data
     */
    void setCardData(String cardData);

    /**
     * Returns encrypted tags for operation Fast track
     *
     * @return String, starts by 0x sequence. After start sequence placed hex value of encrypted tags.
     * After decryption - string contains hex value in TLV format.
     */
    String getCardDataEnc();

    /**
     * Sets card data enc.
     *
     * @param cardDataEnc the card data enc
     */
    void setCardDataEnc(String cardDataEnc);

    /**
     * Returns merchant ID on host.
     *
     * @return String contains merchant ID in host format
     */
    String getMerchantId();

    /**
     * Sets merchant id.
     *
     * @param merchantId the merchant id
     */
    void setMerchantId(String merchantId);

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getTVR();

    /**
     * Sets tvr.
     *
     * @param TVR the tvr
     */
    void setTVR(String TVR);

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getTSI();

    /**
     * Sets tsi.
     *
     * @param TSI the tsi
     */
    void setTSI(String TSI);

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getTC();

    /**
     * Sets tc.
     *
     * @param TC the tc
     */
    void setTC(String TC);

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getCID();

    /**
     * Sets cid.
     *
     * @param CID the cid
     */
    void setCID(String CID);

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getKVR();

    /**
     * Sets kvr.
     *
     * @param KVR the kvr
     */
    void setKVR(String KVR);

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getCDAResult();

    /**
     * Set cda result.
     *
     * @param CDAResult the cda result
     */
    void setCDAResult(String CDAResult);

    /**
     * Return total sales amount from last settlement
     *
     * @return Sales amount from last settlement
     */

    long getSalesAmount();

    /**
     * Set total sales amount from last settlement
     * @param amount Value in range [0, 999999999999]
     */
    void setSalesAmount(long amount);

    /**
     * Return total void amount from last settlement
     *
     * @return Sales void from last settlement
     */

    long getVoidAmount();

    /**
     * Set total void amount from last settlement
     * @param amount Value in range [0, 999999999999]
     */
    void setVoidAmount(long amount);

    /**
     * Return total refund amount from last settlement
     *
     * @return Sales refund from last settlement
     */
    long getRefundAmount();

    /**
     * Set total sales amount from last settlement
     * @param amount Value in range [0, 999999999999]
     */
    void setRefundAmount(long amount);

    /**
     * Returns sales count, executed after last settlement
     *
     * @return Sales count after last settlement
     */
    int getSalesCount();

    /**
     * Set sales count.
     *
     * @param salesCount the sales count
     */
    void setSalesCount(int salesCount);

    /**
     * Returns voids count, executed after last settlement
     *
     * @return Voids count after last settlement
     */
    int getVoidCount();

    /**
     * Set void count.
     *
     * @param voidCount the void count
     */
    void setVoidCount(int voidCount);

    /**
     * Returns refunds count, executed after last settlement
     *
     * @return Refunds count after last settlement
     */
    int getRefundCount();

    /**
     * Sets refund count.
     *
     * @param refundCount the refund count
     */
    void setRefundCount(int refundCount);


    /**
     * Returns array of summary info for every sale operations, executed after last settlement
     *
     * @return Set of {@link IResponse} objects
     */
    Set<IResponse> getSalesArray();

    /**
     * Sets sales array.
     *
     * @param salesArray the sales array
     */
    void setSalesArray(Set<IResponse> salesArray);


    /**
     * Returns array of summary info for every void operations, executed after last settlement
     *
     * @return List of {@link IResponse} objects
     */
    Set<IResponse> getVoidArray();

    /**
     * Sets void array.
     *
     * @param voidArray the void array
     */
    void setVoidArray(Set<IResponse> voidArray);

    /**
     * Returns array of summary info for every refund operations, executed after last settlement
     *
     * @return List of {@link IResponse} objects
     */
    Set<IResponse> getRefundArray();

    /**
     * Sets refund array.
     *
     * @param refundArray the refund array
     */
    void setRefundArray(Set<IResponse> refundArray);

    /**
     * Returns hashed Card PAN for FastTrack operation
     * @return String, contains hashed card PAN
     */
    String getCardPANHash();

    /**
     * Sets card pan hash.
     *
     * @param PANHash the pan hash
     */
    void setCardPANHash(String PANHash);

    /**
     * Returns the first line with organization info for print on receipt
     * @return String, contains first line with organization info
     */
    String getReceiptLine1();

    /**
     * Set receipt line 1.
     *
     * @param receiptLine1 the receipt line 1
     */
    void setReceiptLine1(String receiptLine1);

    /**
     * Returns the second line with organization info for print on receipt
     * @return String, contains second line with organization info
     */
    String getReceiptLine2();

    /**
     * Sets receipt line 2.
     *
     * @param receiptLine2 the receipt line 2
     */
    void setReceiptLine2(String receiptLine2);

    /**
     * Returns the third line with organization info for print on receipt
     * @return String, contains third line with organization info
     */
    String getReceiptLine3();

    /**
     * Sets receipt line 3.
     *
     * @param receiptLine3 the receipt line 3
     */
    void setReceiptLine3(String receiptLine3);


    /**
     * Returns the four line with organization info for print on receipt
     * @return String, contains four line with organization info
     */
    String getReceiptLine4();

    /**
     * Sets receipt line 4.
     *
     * @param receiptLine4 the receipt line 4
     */
    void setReceiptLine4(String receiptLine4);

    /**
     * Returns five line with organization info for print on receipt
     * @return String, contains five line with organization info
     */
    String getReceiptLine5();

    /**
     * Sets receipt line 5.
     *
     * @param receiptLine5 the receipt line 5
     */
    void setReceiptLine5(String receiptLine5);

    /**
     * Return finalization status
     * @return if true, then ECR should send FinalizeTransaction
     */
    boolean getFinalizationRequired();

    /**
     * Sets finalization status
     * @param finalizationRequired finalization status. Ture, if finalization required
     */
    void setFinalizationRequired(boolean finalizationRequired);

    /**
     * Return Application label, received from card
     * @return Application label, if exists
     */
    String getApplicationLabel();

    /**
     * Sets application label, received from card
     * @param label String, contains application label
     */
    void setApplicationLabel(String label);
}
