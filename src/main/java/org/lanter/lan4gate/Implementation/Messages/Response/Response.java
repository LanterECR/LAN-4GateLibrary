package org.lanter.lan4gate.Implementation.Messages.Response;

import org.lanter.lan4gate.Messages.Response.CardInputMethodList;
import org.lanter.lan4gate.Messages.Response.CardholderAuthMethodList;
import org.lanter.lan4gate.Messages.Response.IResponse;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.Response.StatusList;

import java.util.*;

public class Response implements IResponse {
    private int mEcrNumber;
    private int mEcrMerchantNumber;
    private OperationsList mOperationCode;
    private OperationsList mOriginalOperationCode;
    private long mTotalAmount;
    private long mPartialAmount;
    private long mAcquirerFeeAmount;
    private long mTerminalFeeAmount;
    private long mTipsAmount;
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
    private String mCardData;
    private String mCardDataEnc;
    private String mMerchantId;
    private String mTVR;
    private String mTSI;
    private String mTC;
    private String mCID;
    private String mKVR;
    private String mCDAResult;
    private long mSalesAmount;
    private long mVoidAmount;
    private long mRefundAmount;
    private int mSalesCount;
    private int mVoidCount;
    private int mRefundCount;
    private String mCardPANHash;
    private String mReceiptLine1;
    private String mReceiptLine2;
    private String mReceiptLine3;
    private String mReceiptLine4;
    private String mReceiptLine5;
    private boolean mFinalizationRequired;
    private String mApplicationLabel;
    private final Set<IResponse> mSalesArray = new HashSet<>();
    private final Set<IResponse> mVoidArray = new HashSet<>();
    private final Set<IResponse> mRefundArray = new HashSet<>();

    private final Set<ResponseFieldsList> mCurrentFields = new HashSet<>();

    private final Set<ResponseFieldsList> mMandatoryFieldsList = new HashSet<>();
    private final Set<ResponseFieldsList> mOptionalFieldsList = new HashSet<>();

    protected final void addMandatoryFields(ResponseFieldsList field) {
        mMandatoryFieldsList.add(field);
    }
    protected final void addMandatoryFieldsGroup(Set<ResponseFieldsList> fieldsGroup) {
        mMandatoryFieldsList.addAll(fieldsGroup);
    }
    protected final void addOptionalFields(ResponseFieldsList field) {
        mOptionalFieldsList.add(field);
    }
    protected final void addOptionalFieldsGroup(Set<ResponseFieldsList> fieldsGroup) {
        mOptionalFieldsList.addAll(fieldsGroup);
    }

    protected final void clearMandatoryFields() { mMandatoryFieldsList.clear(); }
    protected final void clearOptionalFields() { mOptionalFieldsList.clear(); }

    public Response(){
        addMandatoryFields(ResponseFieldsList.EcrNumber);
        addMandatoryFields(ResponseFieldsList.OperationCode);
        addMandatoryFields(ResponseFieldsList.Status);

        addOptionalFields(ResponseFieldsList.ReceiptLine1);
        addOptionalFields(ResponseFieldsList.ReceiptLine2);
        addOptionalFields(ResponseFieldsList.ReceiptLine3);
        addOptionalFields(ResponseFieldsList.ReceiptLine4);
        addOptionalFields(ResponseFieldsList.ReceiptLine5);
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

    @Override
    public Map<ResponseFieldsList, String> packAsString() {
        Map<ResponseFieldsList, String> packedFields = new EnumMap<>(ResponseFieldsList.class);
        for(ResponseFieldsList field : getCurrentFieldsList()) {
            switch (field) {
                case EcrNumber:
                    packedFields.put(field, String.valueOf(getEcrNumber()));
                    break;
                case EcrMerchantNumber:
                    packedFields.put(field, String.valueOf(getEcrMerchantNumber()));
                    break;
                case OperationCode:
                    packedFields.put(field, String.valueOf(getOperationCode().getNumber()));
                    break;
                case OriginalOperationCode:
                    packedFields.put(field, String.valueOf(getOriginalOperationCode().getNumber()));
                    break;
                case TotalAmount:
                    packedFields.put(field, String.valueOf(getTotalAmount()));
                    break;
                case PartialAmount:
                    packedFields.put(field, String.valueOf(getPartialAmount()));
                    break;
                case AcquirerFeeAmount:
                    packedFields.put(field, String.valueOf(getAcquirerFeeAmount()));
                    break;
                case TerminalFeeAmount:
                    packedFields.put(field, String.valueOf(getTerminalFeeAmount()));
                    break;
                case TipsAmount:
                    packedFields.put(field, String.valueOf(getTipsAmount()));
                    break;
                case CurrencyCode:
                    packedFields.put(field, String.valueOf(getCurrencyCode()));
                    break;
                case ReceiptReference:
                    packedFields.put(field, getReceiptReference());
                    break;
                case RRN:
                    packedFields.put(field, getRRN());
                    break;
                case Status:
                    packedFields.put(field, String.valueOf(getStatus().getNumber()));
                    break;
                case OriginalOperationStatus:
                    packedFields.put(field, String.valueOf(getOriginalOperationStatus().getNumber()));
                    break;
                case TransDateTime:
                    packedFields.put(field, getTransDateTime());
                    break;
                case TerminalDateTime:
                    packedFields.put(field, getTerminalDateTime());
                    break;
                case CardPAN:
                    packedFields.put(field, getCardPAN());
                    break;
                case ExpireDate:
                    packedFields.put(field, getExpireDate());
                    break;
                case CardholderName:
                    packedFields.put(field, getCardholderName());
                    break;
                case CardholderAuthMethod:
                    packedFields.put(field, String.valueOf(getCardholderAuthMethod().getNumber()));
                    break;
                case AuthCode:
                    packedFields.put(field, getAuthCode());
                    break;
                case ResponseCode:
                    packedFields.put(field, getResponseCode());
                    break;
                case ResponseText:
                    packedFields.put(field, getResponseText());
                    break;
                case STAN:
                    packedFields.put(field, getSTAN());
                    break;
                case TransactionID:
                    packedFields.put(field, getTransactionID());
                    break;
                case TerminalID:
                    packedFields.put(field, getTerminalID());
                    break;
                case CardEmvAid:
                    packedFields.put(field, getCardEmvAid());
                    break;
                case CardAppName:
                    packedFields.put(field, getCardAppName());
                    break;
                case CardInputMethod:
                    packedFields.put(field, String.valueOf(getCardInputMethod().getNumber()));
                    break;
                case IssuerName:
                    packedFields.put(field, getIssuerName());
                    break;
                case AdditionalInfo:
                    packedFields.put(field, getAdditionalInfo());
                    break;
                case CardData:
                    packedFields.put(field, getCardData());
                    break;
                case CardDataEnc:
                    packedFields.put(field, getCardDataEnc());
                    break;
                case MerchantId:
                    packedFields.put(field, getMerchantId());
                    break;
                case TVR:
                    packedFields.put(field, getTVR());
                    break;
                case TSI:
                    packedFields.put(field, getTSI());
                    break;
                case TC:
                    packedFields.put(field, getTC());
                    break;
                case CID:
                    packedFields.put(field, getCID());
                    break;
                case KVR:
                    packedFields.put(field, getKVR());
                    break;
                case CDAResult:
                    packedFields.put(field, getCDAResult());
                    break;
                case SalesCount:
                    packedFields.put(field, String.valueOf(getSalesCount()));
                    break;
                case VoidCount:
                    packedFields.put(field, String.valueOf(getVoidCount()));
                    break;
                case RefundCount:
                    packedFields.put(field, String.valueOf(getRefundCount()));
                    break;
                case CardPANHash:
                    packedFields.put(field, getCardPANHash());
                    break;
                case ReceiptLine1:
                    packedFields.put(field, getReceiptLine1());
                    break;
                case ReceiptLine2:
                    packedFields.put(field, getReceiptLine2());
                    break;
                case ReceiptLine3:
                    packedFields.put(field, getReceiptLine3());
                    break;
                case ReceiptLine4:
                    packedFields.put(field, getReceiptLine4());
                    break;
                case ReceiptLine5:
                    packedFields.put(field, getReceiptLine5());
                    break;
            }
        }
        return packedFields;
    }

    @Override
    public Map<ResponseFieldsList, Object> packAsObject() {
        Map<ResponseFieldsList, Object> packedFields = new EnumMap<>(ResponseFieldsList.class);
        for(ResponseFieldsList field : getCurrentFieldsList()) {
            switch (field) {
                case EcrNumber:
                    packedFields.put(field, getEcrNumber());
                    break;
                case EcrMerchantNumber:
                    packedFields.put(field, getEcrMerchantNumber());
                    break;
                case OperationCode:
                    packedFields.put(field, getOperationCode());
                    break;
                case OriginalOperationCode:
                    packedFields.put(field, getOriginalOperationCode());
                    break;
                case PartialAmount:
                    packedFields.put(field, getPartialAmount());
                    break;
                case TotalAmount:
                    packedFields.put(field, getTotalAmount());
                    break;
                case AcquirerFeeAmount:
                    packedFields.put(field, getAcquirerFeeAmount());
                    break;
                case TerminalFeeAmount:
                    packedFields.put(field, getTerminalFeeAmount());
                    break;
                case TipsAmount:
                    packedFields.put(field, getTipsAmount());
                    break;
                case CurrencyCode:
                    packedFields.put(field, getCurrencyCode());
                    break;
                case ReceiptReference:
                    packedFields.put(field, getReceiptReference());
                    break;
                case RRN:
                    packedFields.put(field, getRRN());
                    break;
                case Status:
                    packedFields.put(field, getStatus());
                    break;
                case OriginalOperationStatus:
                    packedFields.put(field, getOriginalOperationStatus());
                    break;
                case TransDateTime:
                    packedFields.put(field, getTransDateTime());
                    break;
                case TerminalDateTime:
                    packedFields.put(field, getTerminalDateTime());
                    break;
                case CardPAN:
                    packedFields.put(field, getCardPAN());
                    break;
                case ExpireDate:
                    packedFields.put(field, getExpireDate());
                    break;
                case CardholderName:
                    packedFields.put(field, getCardholderName());
                    break;
                case CardholderAuthMethod:
                    packedFields.put(field, getCardholderAuthMethod());
                    break;
                case AuthCode:
                    packedFields.put(field, getAuthCode());
                    break;
                case ResponseCode:
                    packedFields.put(field, getResponseCode());
                    break;
                case ResponseText:
                    packedFields.put(field, getResponseText());
                    break;
                case STAN:
                    packedFields.put(field, getSTAN());
                    break;
                case TransactionID:
                    packedFields.put(field, getTransactionID());
                    break;
                case TerminalID:
                    packedFields.put(field, getTerminalID());
                    break;
                case CardEmvAid:
                    packedFields.put(field, getCardEmvAid());
                    break;
                case CardAppName:
                    packedFields.put(field, getCardAppName());
                    break;
                case CardInputMethod:
                    packedFields.put(field, getCardInputMethod());
                    break;
                case IssuerName:
                    packedFields.put(field, getIssuerName());
                    break;
                case AdditionalInfo:
                    packedFields.put(field, getAdditionalInfo());
                    break;
                case CardData:
                    packedFields.put(field, getCardData());
                    break;
                case CardDataEnc:
                    packedFields.put(field, getCardDataEnc());
                    break;
                case MerchantId:
                    packedFields.put(field, getMerchantId());
                    break;
                case TVR:
                    packedFields.put(field, getTVR());
                    break;
                case TSI:
                    packedFields.put(field, getTSI());
                    break;
                case TC:
                    packedFields.put(field, getTC());
                    break;
                case CID:
                    packedFields.put(field, getCID());
                    break;
                case KVR:
                    packedFields.put(field, getKVR());
                    break;
                case CDAResult:
                    packedFields.put(field, getCDAResult());
                    break;
                case SalesCount:
                    packedFields.put(field, getSalesCount());
                    break;
                case VoidCount:
                    packedFields.put(field, getVoidCount());
                    break;
                case RefundCount:
                    packedFields.put(field, getRefundCount());
                    break;
                case SalesArray:
                    packedFields.put(field, getSalesArray());
                    break;
                case VoidArray:
                    packedFields.put(field, getVoidArray());
                    break;
                case RefundArray:
                    packedFields.put(field, getRefundArray());
                    break;
                case CardPANHash:
                    packedFields.put(field, getCardPANHash());
                    break;
                case ReceiptLine1:
                    packedFields.put(field, getReceiptLine1());
                    break;
                case ReceiptLine2:
                    packedFields.put(field, getReceiptLine2());
                    break;
                case ReceiptLine3:
                    packedFields.put(field, getReceiptLine3());
                    break;
                case ReceiptLine4:
                    packedFields.put(field, getReceiptLine4());
                    break;
                case ReceiptLine5:
                    packedFields.put(field, getReceiptLine5());
                    break;
            }
        }
        return packedFields;
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

    public long getTotalAmount() {
        return mTotalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        mTotalAmount = totalAmount;
        mCurrentFields.add(ResponseFieldsList.TotalAmount);
    }

    @Override
    public long getPartialAmount() {
        return mPartialAmount;
    }

    public void setPartialAmount(long partialAmount) {
        mPartialAmount = partialAmount;
        mCurrentFields.add(ResponseFieldsList.PartialAmount);
    }
    public long getAcquirerFeeAmount() {
        return mAcquirerFeeAmount;
    }

    public void setAcquirerFeeAmount(long amountAcquirerFee) {
        mAcquirerFeeAmount = amountAcquirerFee;
        mCurrentFields.add(ResponseFieldsList.AcquirerFeeAmount);
    }

    public long getTerminalFeeAmount() {
        return mTerminalFeeAmount;
    }

    public void setTerminalFeeAmount(long amountTerminalFee) {
        mTerminalFeeAmount = amountTerminalFee;
        mCurrentFields.add(ResponseFieldsList.TerminalFeeAmount);
    }

    public long getTipsAmount() {
        return mTipsAmount;
    }

    public void setTipsAmount(long tipsAmount) {
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

    @Override
    public String getCardData() {
        return mCardData;
    }

    public void setAdditionalInfo(String additionalInfo) {
        mAdditionalInfo = additionalInfo;
        mCurrentFields.add(ResponseFieldsList.AdditionalInfo);
    }

    public String getCardDataEnc() {
        return mCardDataEnc;
    }

    public void setCardData(String cardData) {
        mCardData = cardData;
        mCurrentFields.add(ResponseFieldsList.CardData);
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

    @Override
    public long getSalesAmount() {
        return mSalesAmount;
    }

    @Override
    public void setSalesAmount(long amount) {
        mSalesAmount = amount;
        mCurrentFields.add(ResponseFieldsList.SalesAmount);
    }

    @Override
    public long getVoidAmount() {
        return mVoidAmount;
    }

    @Override
    public void setVoidAmount(long amount) {
        mVoidAmount = amount;
        mCurrentFields.add(ResponseFieldsList.VoidAmount);
    }

    @Override
    public long getRefundAmount() {
        return mRefundAmount;
    }

    @Override
    public void setRefundAmount(long amount) {
        mRefundAmount = amount;
        mCurrentFields.add(ResponseFieldsList.RefundAmount);
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

    public Set<IResponse> getSalesArray() {
        return mSalesArray;
    }
    public void setSalesArray(Set<IResponse> salesArray) {
        if(!salesArray.isEmpty()) {
            mSalesArray.addAll(salesArray);
            mCurrentFields.add(ResponseFieldsList.SalesArray);
        }
    }

    public Set<IResponse> getVoidArray() {
        return mVoidArray;
    }

    public void setVoidArray(Set<IResponse> voidArray) {
        if(!voidArray.isEmpty()) {
            mVoidArray.addAll(voidArray);
            mCurrentFields.add(ResponseFieldsList.VoidArray);
        }
    }

    public Set<IResponse> getRefundArray() {
        return mRefundArray;
    }
    public void setRefundArray(Set<IResponse> refundArray) {
        if(!refundArray.isEmpty()) {
            mRefundArray.addAll(refundArray);
            mCurrentFields.add(ResponseFieldsList.RefundArray);
        }
    }

    @Override
    public String getCardPANHash() {
        return mCardPANHash;
    }
    public void setCardPANHash(String PANHash) {

        mCardPANHash = PANHash;
        mCurrentFields.add(ResponseFieldsList.CardPANHash);
    }
    @Override
    public String getReceiptLine1() {
        return mReceiptLine1;
    }

    public void setReceiptLine1(String receiptLine1) {
        mReceiptLine1 = receiptLine1;
        mCurrentFields.add(ResponseFieldsList.ReceiptLine1);
    }

    @Override
    public String getReceiptLine2() {
        return mReceiptLine2;
    }

    public void setReceiptLine2(String receiptLine2) {
        mReceiptLine2 = receiptLine2;
        mCurrentFields.add(ResponseFieldsList.ReceiptLine2);
    }

    @Override
    public String getReceiptLine3() {
        return mReceiptLine3;
    }

    public void setReceiptLine3(String receiptLine3) {
        mReceiptLine3 = receiptLine3;
        mCurrentFields.add(ResponseFieldsList.ReceiptLine3);
    }

    @Override
    public String getReceiptLine4() {
        return mReceiptLine4;
    }

    public void setReceiptLine4(String receiptLine4) {
        mReceiptLine4 = receiptLine4;
        mCurrentFields.add(ResponseFieldsList.ReceiptLine4);
    }

    @Override
    public String getReceiptLine5() {
        return mReceiptLine5;
    }

    @Override
    public boolean getFinalizationRequired() {
        return mFinalizationRequired;
    }

    public void setFinalizationRequired(boolean finalizationRequired) {
        mFinalizationRequired = finalizationRequired;
        mCurrentFields.add(ResponseFieldsList.FinalizationRequired);
    }



    public void setReceiptLine5(String receiptLine5) {
        mReceiptLine5 = receiptLine5;
        mCurrentFields.add(ResponseFieldsList.ReceiptLine5);
    }

    @Override
    public String getApplicationLabel() {
        return mApplicationLabel;
    }

    public void setApplicationLabel(String label) {
        mApplicationLabel = label;
        mCurrentFields.add(ResponseFieldsList.ApplicationLabel);
    }
}
