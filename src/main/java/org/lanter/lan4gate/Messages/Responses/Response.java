package org.lanter.lan4gate.Messages.Responses;

import org.lanter.lan4gate.IResponse;
import org.lanter.lan4gate.Messages.Fields.*;
import org.lanter.lan4gate.Messages.OperationsList;

import java.util.HashSet;
import java.util.Set;

public class Response implements IResponse {
    private int mEcrNumber;
    private int mEcrMerchantNumber;
    private OperationsList mOperationCode;
    private OperationsList mOriginalOperationCode;
    private int mTotalAmount;
    private int mAcquirerFeeAmount;
    private int mTerminalFeeAmount;
    private int mTipsAmount;
    private int mCurrencyCode;
    private String mReceiptReference;
    private String mRRN;
    private StatusList mStatus;
    private StatusList mOriginalOperationStatus;
    private String mTransDateTime;
    private String mTerminalDateTime;
    private String mCardPAN;
    private String mExpireDate;
    private String mCardholderName;
    private CardholderAuthMethodList mCardholderAuthMethod;
    private String mAuthCode;
    private String mResponseCode;
    private String mResponseText;
    private String mSTAN;
    private String mTransactionID;
    private String mTerminalID;
    private String mCardEmvAid;
    private String mCardAppName;
    private CardInputMethodList mCardInputMethod;
    private String mIssuerName;
    private String mAdditionalInfo;
    private String mCardDataEnc;
    private String mMerchantId;
    private String mTVR;
    private String mTSI;
    private String mTC;
    private String mCID;
    private String mKVR;
    private String mCDAResult;
    private int mSalesCount;
    private int mVoidCount;
    private int mRefundCount;
    private final Set<Response> mSalesArray = new HashSet<>();
    private final Set<Response> mVoidArray = new HashSet<>();
    private final Set<Response> mRefundArray = new HashSet<>();

    private final Set<ResponseFieldsList> mCurrentFields = new HashSet<>();

    private final Set<ResponseFieldsList> mMandatoryFieldsList = new HashSet<>();
    private final Set<ResponseFieldsList> mOptionalFieldsList = new HashSet<>();

    protected final void addMandatoryFields(ResponseFieldsList field) {
        mMandatoryFieldsList.add(field);
    }
    protected final void addOptionalFields(ResponseFieldsList field) {
        mOptionalFieldsList.add(field);
    }

    protected final void clearMandatoryFields() { mMandatoryFieldsList.clear(); }
    protected final void clearOptionalFields() { mOptionalFieldsList.clear(); }

    public Response(){
        addMandatoryFields(ResponseFieldsList.EcrNumber);
        addMandatoryFields(ResponseFieldsList.OperationCode);
    }

    public Set<ResponseFieldsList> getMandatoryFields() {
        return mMandatoryFieldsList;
    }

    public Set<ResponseFieldsList> getOptionalFields() {
        return mOptionalFieldsList;
    }

    public Set<ResponseFieldsList> getCurrentFieldsList() {
        return mCurrentFields;
    }

    public boolean checkMandatoryFields() {
        return mCurrentFields.containsAll(mMandatoryFieldsList);
    }

    public int getEcrNumber() {
        return mEcrNumber;
    }

    public void setEcrNumber(int ecrNumber) {
        mEcrNumber = ecrNumber;
        mCurrentFields.add(ResponseFieldsList.EcrNumber);
    }

    public int getEcrMerchantNumber() {
        return mEcrMerchantNumber;
    }

    public void setEcrMerchantNumber(int ecrMerchantNumber) {
        mEcrMerchantNumber = ecrMerchantNumber;
        mCurrentFields.add(ResponseFieldsList.EcrMerchantNumber);
    }

    public OperationsList getOperationCode() {
        return mOperationCode;
    }

    public void setOperationCode(OperationsList operationCode) {
        if(operationCode != null) {
            mOperationCode = operationCode;
            mCurrentFields.add(ResponseFieldsList.OperationCode);
        }
    }

    public OperationsList getOriginalOperationCode() {
        return mOriginalOperationCode;
    }

    public void setOriginalOperationCode(OperationsList originalOperationCode) {
        if(originalOperationCode != null) {
            mOriginalOperationCode = originalOperationCode;
            mCurrentFields.add(ResponseFieldsList.OriginalOperationCode);
        }
    }

    public int getTotalAmount() {
        return mTotalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        mTotalAmount = totalAmount;
        mCurrentFields.add(ResponseFieldsList.TotalAmount);
    }

    public int getAcquirerFeeAmount() {
        return mAcquirerFeeAmount;
    }

    public void setAcquirerFeeAmount(int amountAcquirerFee) {
        mAcquirerFeeAmount = amountAcquirerFee;
        mCurrentFields.add(ResponseFieldsList.AcquirerFeeAmount);
    }

    public int getTerminalFeeAmount() {
        return mTerminalFeeAmount;
    }

    public void setTerminalFeeAmount(int amountTerminalFee) {
        mTerminalFeeAmount = amountTerminalFee;
        mCurrentFields.add(ResponseFieldsList.TerminalFeeAmount);
    }

    public int getTipsAmount() {
        return mTipsAmount;
    }

    public void setTipsAmount(int tipsAmount) {
        mTipsAmount = tipsAmount;
        mCurrentFields.add(ResponseFieldsList.TipsAmount);
    }

    public int getCurrencyCode() {
        return mCurrencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        mCurrencyCode = currencyCode;
        mCurrentFields.add(ResponseFieldsList.CurrencyCode);
    }

    public String getReceiptReference() {
        return mReceiptReference;
    }

    public void setReceiptReference(String receiptReference) {
        mReceiptReference = receiptReference;
        mCurrentFields.add(ResponseFieldsList.ReceiptReference);
    }

    public String getRRN() {
        return mRRN;
    }

    public void setRRN(String RRN) {
        mRRN = RRN;
        mCurrentFields.add(ResponseFieldsList.RRN);
    }

    public StatusList getStatus() {
        return mStatus;
    }

    public void setStatus(StatusList status) {
        if(status != null) {
            mStatus = status;
            mCurrentFields.add(ResponseFieldsList.Status);
        }
    }

    public StatusList getOriginalOperationStatus() {
        return mOriginalOperationStatus;
    }

    public void setOriginalOperationStatus(StatusList originalOperationStatus) {
        mOriginalOperationStatus = originalOperationStatus;
        mCurrentFields.add(ResponseFieldsList.OriginalOperationStatus);
    }

    public String getTransDateTime() {
        return mTransDateTime;
    }

    public void setTransDateTime(String transDateTime) {
        mTransDateTime = transDateTime;
        mCurrentFields.add(ResponseFieldsList.TransDateTime);
    }

    public String getTerminalDateTime() {
        return mTerminalDateTime;
    }

    public void setTerminalDateTime(String terminalDateTime) {
        mTerminalDateTime = terminalDateTime;
        mCurrentFields.add(ResponseFieldsList.TerminalDateTime);
    }

    public String getCardPAN() {
        return mCardPAN;
    }

    public void setCardPAN(String cardPAN) {
        mCardPAN = cardPAN;
        mCurrentFields.add(ResponseFieldsList.CardPAN);
    }

    public String getExpireDate() {
        return mExpireDate;
    }

    public void setExpireDate(String expireDate) {
        mExpireDate = expireDate;
        mCurrentFields.add(ResponseFieldsList.ExpireDate);
    }

    public String getCardholderName() {
        return mCardholderName;
    }

    public void setCardholderName(String cardholderName) {
        mCardholderName = cardholderName;
        mCurrentFields.add(ResponseFieldsList.CardholderName);
    }

    public CardholderAuthMethodList getCardholderAuthMethod() {
        return mCardholderAuthMethod;
    }

    public void setCardholderAuthMethod(CardholderAuthMethodList cardholderAuthMethod) {
        mCardholderAuthMethod = cardholderAuthMethod;
        mCurrentFields.add(ResponseFieldsList.CardholderAuthMethod);
    }

    public String getAuthCode() {
        return mAuthCode;
    }

    public void setAuthCode(String authCode) {
        mAuthCode = authCode;
        mCurrentFields.add(ResponseFieldsList.AuthCode);
    }

    public String getResponseCode() {
        return mResponseCode;
    }

    public void setResponseCode(String responseCode) {
        mResponseCode = responseCode;
        mCurrentFields.add(ResponseFieldsList.ResponseCode);
    }

    public String getResponseText() {
        return mResponseText;
    }

    public void setResponseText(String responseText) {
        mResponseText = responseText;
        mCurrentFields.add(ResponseFieldsList.ResponseText);
    }

    public String getSTAN() {
        return mSTAN;
    }

    public void setSTAN(String STAN) {
        mSTAN = STAN;
        mCurrentFields.add(ResponseFieldsList.STAN);
    }

    public String getTransactionID() {
        return mTransactionID;
    }

    public void setTransactionID(String transactionID) {
        mTransactionID = transactionID;
        mCurrentFields.add(ResponseFieldsList.TransactionID);
    }

    public String getTerminalID() {
        return mTerminalID;
    }

    public void setTerminalID(String terminalID) {
        mTerminalID = terminalID;
        mCurrentFields.add(ResponseFieldsList.TerminalID);
    }

    public String getCardEmvAid() {
        return mCardEmvAid;
    }

    public void setCardEmvAid(String cardEmvAid) {
        mCardEmvAid = cardEmvAid;
        mCurrentFields.add(ResponseFieldsList.CardEmvAid);
    }

    public String getCardAppName() {
        return mCardAppName;
    }

    public void setCardAppName(String cardAppName) {
        mCardAppName = cardAppName;
        mCurrentFields.add(ResponseFieldsList.CardAppName);
    }

    public CardInputMethodList getCardInputMethod() {
        return mCardInputMethod;
    }

    public void setCardInputMethod(CardInputMethodList cardInputMethod) {
        if(cardInputMethod != null) {
            mCardInputMethod = cardInputMethod;
            mCurrentFields.add(ResponseFieldsList.CardInputMethod);
        }
    }

    public String getIssuerName() {
        return mIssuerName;
    }

    public void setIssuerName(String issuerName) {
        mIssuerName = issuerName;
        mCurrentFields.add(ResponseFieldsList.IssuerName);
    }

    public String getAdditionalInfo() {
        return mAdditionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        mAdditionalInfo = additionalInfo;
        mCurrentFields.add(ResponseFieldsList.AdditionalInfo);
    }

    public String getCardDataEnc() {
        return mCardDataEnc;
    }

    public void setCardDataEnc(String cardDataEnc) {
        mCardDataEnc = cardDataEnc;
        mCurrentFields.add(ResponseFieldsList.CardDataEnc);
    }

    public String getMerchantId() {
        return mMerchantId;
    }

    public void setMerchantId(String merchantId) {
        mMerchantId = merchantId;
        mCurrentFields.add(ResponseFieldsList.MerchantId);
    }

    public String getTVR() {
        return mTVR;
    }

    public void setTVR(String TVR) {
        mTVR = TVR;
        mCurrentFields.add(ResponseFieldsList.TVR);
    }

    public String getTSI() {
        return mTSI;
    }

    public void setTSI(String TSI) {
        mTSI = TSI;
        mCurrentFields.add(ResponseFieldsList.TSI);
    }

    public String getTC() {
        return mTC;
    }

    public void setTC(String TC) {
        mTC = TC;
        mCurrentFields.add(ResponseFieldsList.TC);
    }

    public String getCID() {
        return mCID;
    }

    public void setCID(String CID) {
        mCID = CID;
        mCurrentFields.add(ResponseFieldsList.CID);
    }

    public String getKVR() {
        return mKVR;
    }

    public void setKVR(String KVR) {
        mKVR = KVR;
        mCurrentFields.add(ResponseFieldsList.KVR);
    }

    public String getCDAResult() {
        return mCDAResult;
    }

    public void setCDAResult(String CDAResult) {
        mCDAResult = CDAResult;
        mCurrentFields.add(ResponseFieldsList.CDAResult);
    }

    public int getSalesCount() {
        return mSalesCount;
    }

    public void setSalesCount(int salesCount) {
        mSalesCount = salesCount;
        mCurrentFields.add(ResponseFieldsList.SalesCount);
    }

    public int getVoidCount() {
        return mVoidCount;
    }

    public void setVoidCount(int voidCount) {
        mVoidCount = voidCount;
        mCurrentFields.add(ResponseFieldsList.VoidCount);
    }

    public int getRefundCount() {
        return mRefundCount;
    }

    public void setRefundCount(int refundCount) {
        mRefundCount = refundCount;
        mCurrentFields.add(ResponseFieldsList.RefundCount);
    }

    public Set<Response> getSalesArray() {
        return mSalesArray;
    }
    public void setSalesArray(Set<Response> salesArray) {
        if(!salesArray.isEmpty()) {
            mSalesArray.addAll(salesArray);
            mCurrentFields.add(ResponseFieldsList.SalesArray);
        }
    }

    public Set<Response> getVoidArray() {
        return mVoidArray;
    }

    public void setVoidArray(Set<Response> voidArray) {
        if(!voidArray.isEmpty()) {
            mVoidArray.addAll(voidArray);
            mCurrentFields.add(ResponseFieldsList.VoidArray);
        }
    }

    public Set<Response> getRefundArray() {
        return mRefundArray;
    }
    public void setRefundArray(Set<Response> refundArray) {
        if(!refundArray.isEmpty()) {
            mRefundArray.addAll(refundArray);
            mCurrentFields.add(ResponseFieldsList.RefundArray);
        }
    }
}
