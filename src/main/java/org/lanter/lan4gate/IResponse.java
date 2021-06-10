package org.lanter.lan4gate;

import org.lanter.lan4gate.Messages.Fields.*;
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
    Set<ResponseFieldsList> getCurrentFieldsList();

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
     * Returns logical ECR merchant number, that terminal received in request.
     *
     * @return Logical ECR number
     */
    int getEcrMerchantNumber();

    /**
     * Returns executed operation code.
     *
     * @return One of {@link OperationsList} enum values
     */
    OperationsList getOperationCode();

    /**
     * Returns operation code for original operation. Relevant for operations same as PrintReceiptCopy.
     *
     * @return One of {@link OperationsList} enum values
     */
    OperationsList getOriginalOperationCode();

    /**
     * Returns total amount in minimum currency units for executed operation.
     * Value is sum of amount from request, acquirer fee, terminal fee and tips amount
     *
     * @return Value in range [0, 999999999999]
     */
    long getTotalAmount();

    /**
     * Returns partial amount in minimum currency units for executed operation.
     * Value is sum of amount from request, acquirer fee, terminal fee and tips amount
     *
     * @return Value in range [0, 999999999999]
     */
    long getPartialAmount();

    /**
     * Returns acquirer fee amount in minimum currency units for executed operation.
     *
     * @return Value in range [0, 999999999999]
     */
    long getAcquirerFeeAmount();

    /**
     * Returns the terminal fee amount in minimum currency units for executed operation.
     *
     * @return Value in range [0, 999999999999]
     */
    long getTerminalFeeAmount();

    /**
     * Returns tips amount in minimum currency units for executed operation.
     *
     * @return Value in range [0, 999999999999]
     */
    long getTipsAmount();

    /**
     * Gets currency code.
     *
     * @return the currency code
     */
    int getCurrencyCode();

    /**
     * Returns currency code according to ISO 4217 for executed operation.
     * For example, russian ruble has 643 code
     *
     * @return  Value in range [1, 999]
     */
    String getReceiptReference();

    /**
     * Return RRN code for executed operation.
     *
     * @return the rrn
     */
    String getRRN();

    /**
     * Return result status for executed operation.
     *
     * @return One of {@link StatusList} enum values.
     */
    StatusList getStatus();

    /**
     * Returns result status for original operation. Relevant for operations same as PrintReceiptCopy.
     *
     * @return One of {@link StatusList} enum values.
     */
    StatusList getOriginalOperationStatus();

    /**
     * Returns date and time from host, when operation was executed.
     *
     * @return String in host format. Usually is "YYYYMMDDHHMMSS"
     */
    String getTransDateTime();

    /**
     * Returns date and time from terminal, when operation was executed.
     *
     * @return String in format "YYYYMMDDHHMMSS"
     */
    String getTerminalDateTime();

    /**
     * Return masked card PAN
     *
     * @return String, contains masked by asterisk card PAN
     */
    String getCardPAN();

    /**
     * Returns card expire date
     *
     * @return String in format "YYMM"
     */
    String getExpireDate();

    /**
     * Return cardholder name
     *
     * @return String, contains cardholder name
     */
    String getCardholderName();

    /**
     * Returns cardholder auth method, that used in operation processing
     *
     * @return On of {@link CardholderAuthMethodList} enum values.
     */
    CardholderAuthMethodList getCardholderAuthMethod();

    /**
     * Returns auth code from host
     *
     * @return String contains auth code in host format
     */
    String getAuthCode();

    /**
     * Returns response code from host
     *
     * @return String contains response code in host format
     */
    String getResponseCode();

    /**
     * Returns response text from host or terminal
     *
     * @return String, contains response text in UTF-8. May contains russian language.
     */
    String getResponseText();

    /**
     * Returns terminal transaction ID
     *
     * @return String, contains terminal transaction ID
     */
    String getSTAN();

    /**
     * Returns host transaction ID
     *
     * @return String, contains host transaction ID
     */
    String getTransactionID();

    /**
     * Returns terminal ID registered on host
     *
     * @return String, contains terminal ID registered on host
     */
    String getTerminalID();

    /**
     * Returns card EMV application ID.
     *
     * @return String contains card EMV application ID.
     */
    String getCardEmvAid();

    /**
     * Returns card application name.
     *
     * @return String contains card application name
     */
    String getCardAppName();

    /**
     * Returns card input method, that used in operation processing
     *
     * @return One of {@link CardInputMethodList} enum values.
     */
    CardInputMethodList getCardInputMethod();

    /**
     * Returns issuer name.
     *
     * @return the issuer name
     */
    String getIssuerName();

    /**
     * Returns additional info for executed operation.
     *
     * @return Format, length and type provides by concrete operations. See protocol documentation
     */
    String getAdditionalInfo();

    /**
     * Returns non encrypted tags for operation Fast track
     *
     * @return String contains text hex value in TLV format, starts by 0x sequence. Case may be any
     */
    String getCardData();

    /**
     * Returns encrypted tags for operation Fast track
     *
     * @return String, starts by 0x sequence. After start sequence placed hex value of encrypted tags.
     * After decryption - string contains hex value in TLV format.
     */
    String getCardDataEnc();

    /**
     * Returns merchant ID on host.
     *
     * @return String contains merchant ID in host format
     */
    String getMerchantId();

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getTVR();

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getTSI();

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getTC();

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getCID();

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getKVR();

    /**
     * Card additional data result.
     * Only for printing
     *
     * @return String for printing
     */
    String getCDAResult();

    /**
     * Returns sales count, executed after last settlement
     *
     * @return Sales count after last settlement
     */
    int getSalesCount();

    /**
     * Returns voids count, executed after last settlement
     *
     * @return Voids count after last settlement
     */
    int getVoidCount();

    /**
     * Returns refunds count, executed after last settlement
     *
     * @return Refunds count after last settlement
     */
    int getRefundCount();

    /**
     * Returns array of summary info for every sale operations, executed after last settlement
     *
     * @return Set of {@link IResponse} objects
     */
    Set<IResponse> getSalesArray();

    /**
     * Returns array of summary info for every void operations, executed after last settlement
     *
     * @return List of {@link IResponse} objects
     */
    Set<IResponse> getVoidArray();

    /**
     * Returns array of summary info for every refund operations, executed after last settlement
     *
     * @return List of {@link IResponse} objects
     */
    Set<IResponse> getRefundArray();

    /**
     * Returns hashed Card PAN for FastTrack operation
     * @return String, contains hashed card PAN
     */
    String getCardPANHash();

    /**
     * Returns the first line with organization info for print on receipt
     * @return String, contains first line with organization info
     */
    String getReceiptLine1();

    /**
     * Returns the second line with organization info for print on receipt
     * @return @return String, contains second line with organization info
     */
    String getReceiptLine2();

    /**
     * Returns the third line with organization info for print on receipt
     * @return @return String, contains third line with organization info
     */
    String getReceiptLine3();

    /**
     * Returns the four line with organization info for print on receipt
     * @return @return String, contains four line with organization info
     */
    String getReceiptLine4();

    /**
     * Returns five line with organization info for print on receipt
     * @return @return String, contains five line with organization info
     */
    String getReceiptLine5();

    /**
     * Return finalization status
     * @return if true, then ECR should send FinalizeTransaction
     */
    boolean getFinalizationRequired();

    /**
     * Return Application label, received by card
     * @return Application label, if exists
     */
    String getApplicationLabel();
}
