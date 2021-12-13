package org.lanter.lan4gate.Implementation.MessageProcessor.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.Messages.Response.ArrayStubOperation;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Response.CardInputMethodList;
import org.lanter.lan4gate.Messages.Response.CardholderAuthMethodList;
import org.lanter.lan4gate.Messages.Response.IResponse;
import org.lanter.lan4gate.Messages.Response.ResponseFactory;
import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.Response.StatusList;

import java.util.HashSet;
import java.util.Set;

public class JSONResponseParser {
    public static IResponse parse(JSONObject objectField) throws JSONException {
        IResponse result = null;
        IResponse response = createResponse(getOperationCode(objectField));
        if(response != null) {
            getFields(response.getMandatoryFields(), objectField, response);
            getFields(response.getOptionalFields(), objectField, response);

            if(response.checkMandatoryFields()) {
                result = response;
            }
        }
        return result;
    }
    private static IResponse createResponse(int operationCode) {
        return ResponseFactory.getResponse(OperationsList.getValue(operationCode));
    }

    private static int getOperationCode(JSONObject objectField) {
        return objectField.optInt(ResponseFieldsList.OperationCode.getString(), 0);
    }
    private static void getFields(Set<ResponseFieldsList> fields, JSONObject objectField, IResponse responseObject) throws JSONException {
        for(ResponseFieldsList field : fields ) {
            if(objectField.has(field.getString())) {
                switch (field) {
                    case EcrNumber: {
                        getFieldEcrNumber(objectField, responseObject);
                        break;
                    }
                    case EcrMerchantNumber: {
                        getFieldEcrMerchantNumber(objectField, responseObject);
                        break;
                    }
                    case OriginalOperationCode: {
                        getFieldOriginalOperationCode(objectField, responseObject);
                        break;
                    }
                    case TotalAmount: {
                        getFieldTotalAmount(objectField, responseObject);
                        break;
                    }
                    case PartialAmount: {
                        getFieldPartialAmount(objectField, responseObject);
                        break;
                    }
                    case AcquirerFeeAmount: {
                        getFieldAcquirerFeeAmount(objectField, responseObject);
                        break;
                    }
                    case TerminalFeeAmount: {
                        getFieldTerminalFeeAmount(objectField, responseObject);
                        break;
                    }
                    case TipsAmount: {
                        getFieldTipsAmount(objectField, responseObject);
                        break;
                    }
                    case CurrencyCode: {
                        getFieldCurrencyCode(objectField, responseObject);
                        break;
                    }
                    case ReceiptReference: {
                        getFieldReceiptReference(objectField, responseObject);
                        break;
                    }
                    case RRN : {
                        getFieldRRN (objectField, responseObject);
                        break;
                    }
                    case Status: {
                        getFieldStatus(objectField, responseObject);
                        break;
                    }
                    case OriginalOperationStatus: {
                        getFieldOriginalOperationStatus(objectField, responseObject);
                        break;
                    }
                    case TransDateTime: {
                        getFieldTransDateTime(objectField, responseObject);
                        break;
                    }
                    case TerminalDateTime: {
                        getFieldTerminalDateTime(objectField, responseObject);
                        break;
                    }
                    case CardPAN: {
                        getFieldCardPAN(objectField, responseObject);
                        break;
                    }
                    case ExpireDate: {
                        getFieldExpireDate(objectField, responseObject);
                        break;
                    }
                    case CardholderName: {
                        getFieldCardholderName(objectField, responseObject);
                        break;
                    }
                    case CardholderAuthMethod: {
                        getFieldCardholderAuthMethod(objectField, responseObject);
                        break;
                    }
                    case AuthCode: {
                        getFieldAuthCode(objectField, responseObject);
                        break;
                    }
                    case ResponseCode: {
                        getFieldResponseCode(objectField, responseObject);
                        break;
                    }
                    case ResponseText: {
                        getFieldResponseText(objectField, responseObject);
                        break;
                    }
                    case STAN: {
                        getFieldSTAN(objectField, responseObject);
                        break;
                    }
                    case TransactionID: {
                        getFieldTransactionID(objectField, responseObject);
                        break;
                    }
                    case TerminalID: {
                        getFieldTerminalID(objectField, responseObject);
                        break;
                    }
                    case CardEmvAid: {
                        getFieldCardEmvAid(objectField, responseObject);
                        break;
                    }
                    case CardAppName: {
                        getFieldCardAppName(objectField, responseObject);
                        break;
                    }
                    case CardInputMethod: {
                        getFieldCardInputMethod(objectField, responseObject);
                        break;
                    }
                    case IssuerName: {
                        getFieldIssuerName(objectField, responseObject);
                        break;
                    }
                    case AdditionalInfo: {
                        getFieldAdditionalInfo(objectField, responseObject);
                        break;
                    }
                    case CardData: {
                        getFieldCardData(objectField, responseObject);
                        break;
                    }
                    case CardDataEnc: {
                        getFieldCardDataEnc(objectField, responseObject);
                        break;
                    }
                    case MerchantId: {
                        getFieldMerchantId(objectField, responseObject);
                        break;
                    }
                    case TVR : {
                        getFieldTVR (objectField, responseObject);
                        break;
                    }
                    case TSI : {
                        getFieldTSI (objectField, responseObject);
                        break;
                    }
                    case TC: {
                        getFieldTC(objectField, responseObject);
                        break;
                    }
                    case CID : {
                        getFieldCID (objectField, responseObject);
                        break;
                    }
                    case KVR : {
                        getFieldKVR (objectField, responseObject);
                        break;
                    }
                    case CDAResult: {
                        getFieldCDAResult(objectField, responseObject);
                        break;
                    }
                    case SalesAmount:
                        getFieldSalesAmount(objectField, responseObject);
                        break;
                    case VoidAmount:
                        getFieldVoidAmount(objectField, responseObject);
                        break;
                    case RefundAmount:
                        getFieldRefundAmount(objectField, responseObject);
                        break;
                    case SalesCount : {
                        getFieldSalesCount (objectField, responseObject);
                        break;
                    }
                    case VoidCount: {
                        getFieldVoidCount(objectField, responseObject);
                        break;
                    }
                    case RefundCount: {
                        getFieldRefundCount(objectField, responseObject);
                        break;
                    }
                    case SalesArray: {
                        getFieldSalesArray (objectField, responseObject);
                        break;
                    }
                    case VoidArray: {
                        getFieldVoidArray(objectField, responseObject);
                        break;
                    }
                    case RefundArray: {
                        getFieldRefundArray(objectField, responseObject);
                        break;
                    }
                    case CardPANHash: {
                        getFieldCardPANHash(objectField, responseObject);
                        break;
                    }
                    case ReceiptLine1: {
                        getFieldReceiptLine1(objectField, responseObject);
                        break;
                    }
                    case ReceiptLine2: {
                        getFieldReceiptLine2(objectField, responseObject);
                        break;
                    }
                    case ReceiptLine3: {
                        getFieldReceiptLine3(objectField, responseObject);
                        break;
                    }
                    case ReceiptLine4: {
                        getFieldReceiptLine4(objectField, responseObject);
                        break;
                    }
                    case ReceiptLine5: {
                        getFieldReceiptLine5(objectField, responseObject);
                        break;
                    }
                    case FinalizationRequired:
                        getFieldFinalizationRequired(objectField, responseObject);
                        break;
                    case ApplicationLabel:
                        getFieldApplicationLabel(objectField, responseObject);
                        break;
                }//switch
            }//object has field
        }//foreach
    }//getFields

    private static void getFieldApplicationLabel(JSONObject objectField, IResponse responseObject) {
        String receiptReference = objectField.optString(ResponseFieldsList.ApplicationLabel.getString());
        if(!receiptReference.isEmpty())
        {
            responseObject.setApplicationLabel(receiptReference);
        }
    }

    private static void getFieldEcrNumber(JSONObject objectField, IResponse responseObject) {
        int ecrNumber = objectField.optInt(ResponseFieldsList.EcrNumber.getString(), -1);
        if(ecrNumber != -1)
        {
            responseObject.setEcrNumber(ecrNumber);
        }
    }
    private static void getFieldEcrMerchantNumber(JSONObject objectField, IResponse responseObject) {
        int ecrMerchantNumber = objectField.optInt(ResponseFieldsList.EcrMerchantNumber.getString(), -1);
        if(ecrMerchantNumber != -1)
        {
            responseObject.setEcrMerchantNumber(ecrMerchantNumber);
        }
    }
    private static void getFieldOriginalOperationCode(JSONObject objectField, IResponse responseObject) {
        int originalOperationCode = objectField.optInt(ResponseFieldsList.OriginalOperationCode.getString(), -1);
        if(originalOperationCode != -1)
        {
            responseObject.setOriginalOperationCode(OperationsList.getValue(originalOperationCode));
        }
    }
    private static void getFieldTotalAmount(JSONObject objectField, IResponse responseObject) {
        long totalAmount = objectField.optLong(ResponseFieldsList.TotalAmount.getString(), -1);
        if(totalAmount != -1)
        {
            responseObject.setTotalAmount(totalAmount);
        }
    }
    private static void getFieldPartialAmount(JSONObject objectField, IResponse responseObject) {
        long partialAmount = objectField.optLong(ResponseFieldsList.PartialAmount.getString(), -1);
        if(partialAmount != -1)
        {
            responseObject.setPartialAmount(partialAmount);
        }
    }
    private static void getFieldAcquirerFeeAmount(JSONObject objectField, IResponse responseObject) {
        long acquirerFeeAmount = objectField.optLong(ResponseFieldsList.AcquirerFeeAmount.getString(), -1);
        if(acquirerFeeAmount != -1)
        {
            responseObject.setAcquirerFeeAmount(acquirerFeeAmount);
        }
    }
    private static void getFieldTerminalFeeAmount(JSONObject objectField, IResponse responseObject) {
        long terminalFeeAmount = objectField.optLong(ResponseFieldsList.TerminalFeeAmount.getString(), -1);
        if(terminalFeeAmount != -1)
        {
            responseObject.setTerminalFeeAmount(terminalFeeAmount);
        }
    }
    private static void getFieldTipsAmount(JSONObject objectField, IResponse responseObject) {
        long tipsAmount = objectField.optLong(ResponseFieldsList.TipsAmount.getString(), -1);
        if(tipsAmount != -1)
        {
            responseObject.setTipsAmount(tipsAmount);
        }
    }
    private static void getFieldCurrencyCode(JSONObject objectField, IResponse responseObject) {
        int currencyCode = objectField.optInt(ResponseFieldsList.CurrencyCode.getString(), -1);
        if(currencyCode != -1)
        {
            responseObject.setCurrencyCode(currencyCode);
        }
    }
    private static void getFieldReceiptReference(JSONObject objectField, IResponse responseObject) {
        String receiptReference = objectField.optString(ResponseFieldsList.ReceiptReference.getString());
        if(!receiptReference.isEmpty())
        {
            responseObject.setReceiptReference(receiptReference);
        }
    }
    private static void getFieldRRN (JSONObject objectField, IResponse responseObject) {
        String rrn = objectField.optString(ResponseFieldsList.RRN.getString());
        if(!rrn.isEmpty())
        {
            responseObject.setRRN(rrn);
        }
    }
    private static void getFieldStatus(JSONObject objectField, IResponse responseObject) {
        int status = objectField.optInt(ResponseFieldsList.Status.getString(), -1);
        if(status != -1)
        {
            responseObject.setStatus(StatusList.getValue(status));
        }
    }
    private static void getFieldOriginalOperationStatus(JSONObject objectField, IResponse responseObject) {
        int originalOperationStatus = objectField.optInt(ResponseFieldsList.OriginalOperationStatus.getString(), -1);
        if(originalOperationStatus != -1)
        {
            responseObject.setOriginalOperationStatus(StatusList.getValue(originalOperationStatus));
        }
    }
    private static void getFieldTransDateTime(JSONObject objectField, IResponse responseObject) {
        String transactionDateTime = objectField.optString(ResponseFieldsList.TransDateTime.getString());
        if(!transactionDateTime.isEmpty())
        {
            responseObject.setTransDateTime(transactionDateTime);
        }
    }
    private static void getFieldTerminalDateTime(JSONObject objectField, IResponse responseObject) {
        String terminalDateTime = objectField.optString(ResponseFieldsList.TerminalDateTime.getString());
        if(!terminalDateTime.isEmpty())
        {
            responseObject.setTerminalDateTime(terminalDateTime);
        }
    }
    private static void getFieldCardPAN(JSONObject objectField, IResponse responseObject) {
        String cardPan = objectField.optString(ResponseFieldsList.CardPAN.getString());
        if(!cardPan.isEmpty())
        {
            responseObject.setCardPAN(cardPan);
        }
    }
    private static void getFieldExpireDate(JSONObject objectField, IResponse responseObject) {
        String expireDate = objectField.optString(ResponseFieldsList.ExpireDate.getString());
        if(!expireDate.isEmpty())
        {
            responseObject.setExpireDate(expireDate);
        }
    }
    private static void getFieldCardholderName(JSONObject objectField, IResponse responseObject) {
        String cardholderName = objectField.optString(ResponseFieldsList.CardholderName.getString());
        if(!cardholderName.isEmpty())
        {
            responseObject.setCardholderName(cardholderName);
        }
    }
    private static void getFieldCardholderAuthMethod(JSONObject objectField, IResponse responseObject) {
        int cardholderAuthMethod = objectField.optInt(ResponseFieldsList.CardholderAuthMethod.getString(), -1);
        if(cardholderAuthMethod != -1)
        {
            responseObject.setCardholderAuthMethod(CardholderAuthMethodList.getValue(cardholderAuthMethod));
        }
    }
    private static void getFieldAuthCode(JSONObject objectField, IResponse responseObject) {
        String authCode = objectField.optString(ResponseFieldsList.AuthCode.getString());
        if(!authCode.isEmpty())
        {
            responseObject.setAuthCode(authCode);
        }
    }
    private static void getFieldResponseCode(JSONObject objectField, IResponse responseObject) {
        String responseCode = objectField.optString(ResponseFieldsList.ResponseCode.getString());
        if(!responseCode.isEmpty())
        {
            responseObject.setResponseCode(responseCode);
        }
    }
    private static void getFieldResponseText(JSONObject objectField, IResponse responseObject) {
        String responseText = objectField.optString(ResponseFieldsList.ResponseText.getString());
        if(!responseText.isEmpty())
        {
            responseObject.setResponseText(responseText);
        }
    }
    private static void getFieldSTAN(JSONObject objectField, IResponse responseObject) {
        String stan = objectField.optString(ResponseFieldsList.STAN.getString());
        if(!stan.isEmpty())
        {
            responseObject.setSTAN(stan);
        }
    }
    private static void getFieldTransactionID(JSONObject objectField, IResponse responseObject) {
        String transactionID = objectField.optString(ResponseFieldsList.TransactionID.getString());
        if(!transactionID.isEmpty())
        {
            responseObject.setTransactionID(transactionID);
        }
    }
    private static void getFieldTerminalID(JSONObject objectField, IResponse responseObject) {
        String terminalID = objectField.optString(ResponseFieldsList.TerminalID.getString());
        if(!terminalID.isEmpty())
        {
            responseObject.setTerminalID(terminalID);
        }
    }
    private static void getFieldCardEmvAid(JSONObject objectField, IResponse responseObject) {
        String cardEMVAid = objectField.optString(ResponseFieldsList.CardEmvAid.getString());
        if(!cardEMVAid.isEmpty())
        {
            responseObject.setCardEmvAid(cardEMVAid);
        }
    }
    private static void getFieldCardAppName(JSONObject objectField, IResponse responseObject) {
        String cardAppName = objectField.optString(ResponseFieldsList.CardAppName.getString());
        if(!cardAppName.isEmpty())
        {
            responseObject.setCardAppName(cardAppName);
        }
    }
    private static void getFieldCardInputMethod(JSONObject objectField, IResponse responseObject) {
        int cardInputMethod = objectField.optInt(ResponseFieldsList.CardInputMethod.getString(), -1);
        if(cardInputMethod != -1)
        {
            responseObject.setCardInputMethod(CardInputMethodList.getValue(cardInputMethod));
        }
    }
    private static void getFieldIssuerName(JSONObject objectField, IResponse responseObject) {
        String issuerName = objectField.optString(ResponseFieldsList.IssuerName.getString());
        if(!issuerName.isEmpty())
        {
            responseObject.setIssuerName(issuerName);
        }
    }
    private static void getFieldAdditionalInfo(JSONObject objectField, IResponse responseObject) {
        String additionalInfo = objectField.optString(ResponseFieldsList.AdditionalInfo.getString());
        if(!additionalInfo.isEmpty())
        {
            responseObject.setAdditionalInfo(additionalInfo);
        }
    }
    private static void getFieldCardData(JSONObject objectField, IResponse responseObject) {
        String cardData = objectField.optString(ResponseFieldsList.CardData.getString());
        if(!cardData.isEmpty())
        {
            responseObject.setCardData(cardData);
        }
    }
    private static void getFieldCardDataEnc(JSONObject objectField, IResponse responseObject) {
        String cardDataEnc = objectField.optString(ResponseFieldsList.CardDataEnc.getString());
        if(!cardDataEnc.isEmpty())
        {
            responseObject.setCardDataEnc(cardDataEnc);
        }
    }
    private static void getFieldMerchantId(JSONObject objectField, IResponse responseObject) {
        String merchantID = objectField.optString(ResponseFieldsList.MerchantId.getString());
        if(!merchantID.isEmpty())
        {
            responseObject.setMerchantId(merchantID);
        }
    }
    private static void getFieldTVR (JSONObject objectField, IResponse responseObject) {
        String tvr = objectField.optString(ResponseFieldsList.TVR.getString());
        if(!tvr.isEmpty())
        {
            responseObject.setTVR(tvr);
        }
    }
    private static void getFieldTSI (JSONObject objectField, IResponse responseObject) {
        String tsi = objectField.optString(ResponseFieldsList.TSI.getString());
        if(!tsi.isEmpty())
        {
            responseObject.setTSI(tsi);
        }
    }
    private static void getFieldTC(JSONObject objectField, IResponse responseObject) {
        String tc = objectField.optString(ResponseFieldsList.TC.getString());
        if(!tc.isEmpty())
        {
            responseObject.setTC(tc);
        }
    }
    private static void getFieldCID (JSONObject objectField, IResponse responseObject) {
        String cid = objectField.optString(ResponseFieldsList.CID.getString());
        if(!cid.isEmpty())
        {
            responseObject.setCID(cid);
        }
    }
    private static void getFieldKVR (JSONObject objectField, IResponse responseObject) {
        String kvr = objectField.optString(ResponseFieldsList.KVR.getString());
        if(!kvr.isEmpty())
        {
            responseObject.setKVR(kvr);
        }
    }
    private static void getFieldCDAResult(JSONObject objectField, IResponse responseObject) {
        String cdaResult = objectField.optString(ResponseFieldsList.CDAResult.getString());
        if(!cdaResult.isEmpty())
        {
            responseObject.setCDAResult(cdaResult);
        }
    }



    private static void getFieldSalesAmount(JSONObject objectField, IResponse responseObject) {
        long salesAmount = objectField.optLong(ResponseFieldsList.SalesAmount.getString(), -1);
        if(salesAmount != -1)
        {
            responseObject.setSalesAmount(salesAmount);
        }
    }

    private static void getFieldVoidAmount(JSONObject objectField, IResponse responseObject) {
        long voidAmount = objectField.optLong(ResponseFieldsList.VoidAmount.getString(), -1);
        if(voidAmount != -1)
        {
            responseObject.setVoidAmount(voidAmount);
        }
    }

    private static void getFieldRefundAmount(JSONObject objectField, IResponse responseObject) {
        long refundAmount = objectField.optLong(ResponseFieldsList.RefundAmount.getString(), -1);
        if(refundAmount != -1)
        {
            responseObject.setRefundAmount(refundAmount);
        }
    }

    private static void getFieldSalesCount (JSONObject objectField, IResponse responseObject) {
        int salesCount = objectField.optInt(ResponseFieldsList.SalesCount.getString(), -1);
        if(salesCount != -1)
        {
            responseObject.setSalesCount(salesCount);
        }
    }
    private static void getFieldVoidCount(JSONObject objectField, IResponse responseObject) {
        int voidCount = objectField.optInt(ResponseFieldsList.VoidCount.getString(), -1);
        if(voidCount != -1)
        {
            responseObject.setVoidCount(voidCount);
        }
    }
    private static void getFieldRefundCount(JSONObject objectField, IResponse responseObject) {
        int refundCount = objectField.optInt(ResponseFieldsList.RefundCount.getString(), -1);
        if(refundCount != -1)
        {
            responseObject.setRefundCount(refundCount);
        }
    }
    private static void getFieldSalesArray (JSONObject objectField, IResponse responseObject) throws JSONException {
        responseObject.setSalesArray(parseArray(ResponseFieldsList.SalesArray.getString(), objectField));
    }
    private static void getFieldVoidArray(JSONObject objectField, IResponse responseObject) throws JSONException {
        responseObject.setVoidArray(parseArray(ResponseFieldsList.VoidArray.getString(), objectField));
    }
    private static void getFieldRefundArray(JSONObject objectField, IResponse responseObject) throws JSONException {
        responseObject.setRefundArray(parseArray(ResponseFieldsList.RefundArray.getString(), objectField));
    }
    private static void getFieldCardPANHash (JSONObject objectField, IResponse responseObject) {
        String cardPANHash = objectField.optString(ResponseFieldsList.CardPANHash.getString());
        if(!cardPANHash.isEmpty())
        {
            responseObject.setCardPANHash(cardPANHash);
        }
    }
    private static void getFieldReceiptLine1 (JSONObject objectField, IResponse responseObject) {
        String receiptLine1 = objectField.optString(ResponseFieldsList.ReceiptLine1.getString());
        if(!receiptLine1.isEmpty())
        {
            responseObject.setReceiptLine1(receiptLine1);
        }
    }
    private static void getFieldReceiptLine2 (JSONObject objectField, IResponse responseObject) {
        String receiptLine2 = objectField.optString(ResponseFieldsList.ReceiptLine2.getString());
        if(!receiptLine2.isEmpty())
        {
            responseObject.setReceiptLine2(receiptLine2);
        }
    }
    private static void getFieldReceiptLine3 (JSONObject objectField, IResponse responseObject) {
        String receiptLine3 = objectField.optString(ResponseFieldsList.ReceiptLine3.getString());
        if(!receiptLine3.isEmpty())
        {
            responseObject.setReceiptLine3(receiptLine3);
        }
    }
    private static void getFieldReceiptLine4 (JSONObject objectField, IResponse responseObject) {
        String receiptLine4 = objectField.optString(ResponseFieldsList.ReceiptLine4.getString());
        if(!receiptLine4.isEmpty())
        {
            responseObject.setReceiptLine4(receiptLine4);
        }
    }
    private static void getFieldReceiptLine5 (JSONObject objectField, IResponse responseObject) {
        String receiptLine5 = objectField.optString(ResponseFieldsList.ReceiptLine5.getString());
        if(!receiptLine5.isEmpty())
        {
            responseObject.setReceiptLine5(receiptLine5);
        }
    }
    private static Set<IResponse> parseArray(String arrayName, JSONObject objectField) throws JSONException {
        Set<IResponse> array = new HashSet<>();
        if(objectField.has(arrayName)){
            JSONArray jsonArray = objectField.getJSONArray(arrayName);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentObject = jsonArray.getJSONObject(i);
                IResponse arrayStubOperation = new ArrayStubOperation();
                getFields(arrayStubOperation.getMandatoryFields(), currentObject, arrayStubOperation);
                if(arrayStubOperation.checkMandatoryFields()) {
                    array.add(arrayStubOperation);
                }
            }
        }
        return array;
    }


    private static void getFieldFinalizationRequired(JSONObject objectField, IResponse responseObject) {
        responseObject.setFinalizationRequired(objectField.getBoolean(ResponseFieldsList.FinalizationRequired.getString()));
    }
}
