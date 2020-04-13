package org.lanter.lan4gate.Messages.Requests;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Checkers.RequestMandatoryFieldsChecker;

import java.util.ArrayList;
import java.util.List;

public class Request {
    private int mEcrNumber;
    private int mEcrMerchantNumber;
    private OperationsList mOperationCode = OperationsList.NoOperation;
    private int mAmount;
    private int mTipsAmount;
    private int mCashbackAmount;
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

    private List<RequestFieldsList> mFields = new ArrayList<>();


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

    public void setAmount(int amount) {
        mFields.add(RequestFieldsList.Amount);
        mAmount = amount;
    }

    public int getAmount() {
        return mAmount;
    }

    public void setTipsAmount(int tipsAmount) {
        mFields.add(RequestFieldsList.TipsAmount);
        mTipsAmount = tipsAmount;
    }

    public int getTipsAmount() {
        return mTipsAmount;
    }

    public void setCashbackAmount(int cashbackAmount) {
        mFields.add(RequestFieldsList.CashbackAmount);
        mCashbackAmount = cashbackAmount;
    }
    public int getCashbackAmount() {
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

    public List<RequestFieldsList> getFields() {
        return mFields;
    }

    public boolean checkMandatoryFields() {
        RequestMandatoryFieldsChecker checker = RequestMandatoryFieldsChecker.getChecker(mOperationCode);
        return checker.checkMandatoryFields(mFields);
    }
}
