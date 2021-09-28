package org.lanter.lan4gate.Implementation.Messages.Request;

import org.lanter.lan4gate.Messages.Request.IRequest;
import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;

import java.util.HashSet;
import java.util.Set;

public class Request implements IRequest {
    private int mEcrNumber;
    private int mEcrMerchantNumber;
    private OperationsList mOperationCode;
    private long mAmount;
    private long mPartialAmount;
    private long mTipsAmount;
    private long mCashbackAmount;
    private int mCurrencyCode;
    private String mRRN;
    private String mAuthCode;
    private String mReceiptReference;
    private String mTransactionID;
    private String mCardDataEnc;
    private String mOpenTags;
    private String mEncTags;
    private String mProviderCode;
    private String mAdditionalInfo;

    private final Set<RequestFieldsList> mFields = new HashSet<>();

    private final Set<RequestFieldsList> mMandatoryFieldsList = new HashSet<>();
    private final Set<RequestFieldsList> mOptionalFieldsList = new HashSet<>();

    protected final void addMandatoryFields(RequestFieldsList field) {
        mMandatoryFieldsList.add(field);
    }
    protected final void addOptionalFields(RequestFieldsList field) {
        mOptionalFieldsList.add(field);
    }
    public Request(){
        addMandatoryFields(RequestFieldsList.EcrNumber);
        addMandatoryFields(RequestFieldsList.OperationCode);
    }

    public Set<RequestFieldsList> getMandatoryFields() {
        return mMandatoryFieldsList;
    }

    public Set<RequestFieldsList> getOptionalFields() {
        return mOptionalFieldsList;
    }

    public boolean checkMandatoryFields() {
        return mFields.containsAll(mMandatoryFieldsList);
    }

    public void setEcrNumber(int ecrNumber) {
        mFields.add(RequestFieldsList.EcrNumber);
        mEcrNumber = ecrNumber;
    }

    public int getEcrNumber() {
        return mEcrNumber;
    }

    public void setEcrMerchantNumber(int ecrMerchantNumber) {
        mFields.add(RequestFieldsList.EcrMerchantNumber);
        mEcrMerchantNumber = ecrMerchantNumber;
    }

    public int getEcrMerchantNumber() {
        return mEcrMerchantNumber;
    }

    public void setOperationCode(OperationsList operationCode) {
        mFields.add(RequestFieldsList.OperationCode);
        mOperationCode = operationCode;
    }

    public OperationsList getOperationCode() {
        return mOperationCode;
    }

    public void setAmount(long amount) {
        mFields.add(RequestFieldsList.Amount);
        mAmount = amount;
    }

    public long getAmount() {
        return mAmount;
    }

    @Override
    public void setPartialAmount(long amount) {
        mFields.add(RequestFieldsList.PartialAmount);
        mPartialAmount = amount;
    }

    public long getPartialAmount() {
        return mPartialAmount;
    }
    public void setTipsAmount(long tipsAmount) {
        mFields.add(RequestFieldsList.TipsAmount);
        mTipsAmount = tipsAmount;
    }

    public long getTipsAmount() {
        return mTipsAmount;
    }

    public void setCashbackAmount(long cashbackAmount) {
        mFields.add(RequestFieldsList.CashbackAmount);
        mCashbackAmount = cashbackAmount;
    }
    public long getCashbackAmount() {
        return mCashbackAmount;
    }

    public void setCurrencyCode(int currencyCode) {
        mFields.add(RequestFieldsList.CurrencyCode);
        mCurrencyCode = currencyCode;
    }

    public int getCurrencyCode() {
        return mCurrencyCode;
    }

    public void setRRN(String RRN) {
        mFields.add(RequestFieldsList.RRN);
        this.mRRN = RRN;
    }

    public String getRRN() {
        return mRRN;
    }

    public void setReceiptReference(String receiptReference) {
        mFields.add(RequestFieldsList.ReceiptReference);
        mReceiptReference = receiptReference;
    }

    public String getReceiptReference() {
        return mReceiptReference;
    }


    public void setAuthCode(String authCode) {
        mFields.add(RequestFieldsList.AuthCode);
        mAuthCode = authCode;
    }
    public String getAuthCode() {
        return mAuthCode;
    }

    public void setTransactionID(String transactionID) {
        mFields.add(RequestFieldsList.TransactionID);
        mTransactionID = transactionID;
    }

    public String getTransactionID() {
        return mTransactionID;
    }


    public void setCardDataEnc(String cardDataEnc) {
        mFields.add(RequestFieldsList.CardDataEnc);
        mCardDataEnc = cardDataEnc;
    }
    public String getCardDataEnc() {
        return mCardDataEnc;
    }

    public void setOpenTags(String openTags) {
        mFields.add(RequestFieldsList.OpenTags);
        mOpenTags = openTags;
    }

    public String getOpenTags() {
        return mOpenTags;
    }

    public void setEncTags(String encTags) {
        mFields.add(RequestFieldsList.EncTags);
        mEncTags = encTags;
    }

    public String getEncTags() {
        return mEncTags;
    }

    public void setProviderCode(String providerCode) {
        mFields.add(RequestFieldsList.ProviderCode);
        mProviderCode = providerCode;
    }

    public String getProviderCode() {
        return mProviderCode;
    }

    public void setAdditionalInfo(String additionalInfo) {
        mFields.add(RequestFieldsList.AdditionalInfo);
        mAdditionalInfo = additionalInfo;
    }

    public String getAdditionalInfo() {
        return mAdditionalInfo;
    }

    public Set<RequestFieldsList> getCurrentFields() {
        return mFields;
    }
}
