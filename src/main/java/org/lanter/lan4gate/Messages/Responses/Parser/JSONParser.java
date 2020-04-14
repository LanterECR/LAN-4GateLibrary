package org.lanter.lan4gate.Messages.Responses.Parser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.lanter.lan4gate.Messages.Fields.*;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.Responses.ArrayStubOperation;
import org.lanter.lan4gate.Messages.Responses.Response;
import org.lanter.lan4gate.Messages.Responses.ResponseBuilder;

import java.util.HashSet;
import java.util.Set;

public class JSONParser {
    private Response mResponse;

    public Response getResponse() {
        return mResponse;
    }
    public boolean parse(String json) {
        if(json != null && !json.isEmpty()) {
            JSONObject root = new JSONObject(json);
            if (checkRootFields(root)) {
                JSONObject objectField = getObjectField(root);
                return parseObjectField(objectField);
            }
        }
        return false;
    }
    private boolean checkRootFields(JSONObject root) {
        return checkClassField(root) && checkObjectField(root);
    }
    private boolean checkClassField(JSONObject root) {
        return root != null &&  root.optString(RootFields.CLASS).equals(ClassFieldValuesList.Response.getString());
    }
    private boolean checkObjectField(JSONObject root) {
        return root != null &&  root.has(RootFields.OBJECT);
    }
    private JSONObject getObjectField(JSONObject root) {
       return root.optJSONObject(RootFields.OBJECT);
    }

    private boolean parseObjectField(JSONObject objectField) {
        createResponse(getOperationCode(objectField));
        if(mResponse != null) {
            getFields(mResponse.getMandatoryFields(), objectField, mResponse);
            getFields(mResponse.getOptionalFields(), objectField, mResponse);
        }
        return mResponse != null && mResponse.checkMandatoryFields();
    }
    private void createResponse(int operationCode) {
        ResponseBuilder builder = new ResponseBuilder();
        mResponse = builder.prepareResponse(OperationsList.getValue(operationCode));
    }
    private int getOperationCode(JSONObject objectField) {
        return objectField.optInt(ResponseFieldsList.OperationCode.getString(), 0);
    }

    private void getFields(Set<ResponseFieldsList> fields, JSONObject objectField, Response responseObject) {
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
                }//switch
            }//object has field
        }//foreach
    }//getFields
    private void getFieldEcrNumber(JSONObject objectField, Response responseObject) {
        int ecrNumber = objectField.optInt(ResponseFieldsList.EcrNumber.getString(), -1);
        if(ecrNumber != -1)
        {
            responseObject.setEcrNumber(ecrNumber);
        }
    }
    private void getFieldEcrMerchantNumber(JSONObject objectField, Response responseObject) {
        int ecrMerchantNumber = objectField.optInt(ResponseFieldsList.EcrMerchantNumber.getString(), -1);
        if(ecrMerchantNumber != -1)
        {
            responseObject.setEcrMerchantNumber(ecrMerchantNumber);
        }
    }
    private void getFieldOriginalOperationCode(JSONObject objectField, Response responseObject) {
        int originalOperationCode = objectField.optInt(ResponseFieldsList.OriginalOperationCode.getString(), -1);
        if(originalOperationCode != -1)
        {
            responseObject.setOriginalOperationCode(OperationsList.getValue(originalOperationCode));
        }
    }
    private void getFieldTotalAmount(JSONObject objectField, Response responseObject) {
        int totalAmount = objectField.optInt(ResponseFieldsList.TotalAmount.getString(), -1);
        if(totalAmount != -1)
        {
            responseObject.setTotalAmount(totalAmount);
        }
    }
    private void getFieldAcquirerFeeAmount(JSONObject objectField, Response responseObject) {
        int acquirerFeeAmount = objectField.optInt(ResponseFieldsList.AcquirerFeeAmount.getString(), -1);
        if(acquirerFeeAmount != -1)
        {
            responseObject.setAcquirerFeeAmount(acquirerFeeAmount);
        }
    }
    private void getFieldTerminalFeeAmount(JSONObject objectField, Response responseObject) {
        int terminalFeeAmount = objectField.optInt(ResponseFieldsList.TerminalFeeAmount.getString(), -1);
        if(terminalFeeAmount != -1)
        {
            responseObject.setTerminalFeeAmount(terminalFeeAmount);
        }
    }
    private void getFieldTipsAmount(JSONObject objectField, Response responseObject) {
        int tipsAmount = objectField.optInt(ResponseFieldsList.TipsAmount.getString(), -1);
        if(tipsAmount != -1)
        {
            responseObject.setTipsAmount(tipsAmount);
        }
    }
    private void getFieldCurrencyCode(JSONObject objectField, Response responseObject) {
        int currencyCode = objectField.optInt(ResponseFieldsList.CurrencyCode.getString(), -1);
        if(currencyCode != -1)
        {
            responseObject.setCurrencyCode(currencyCode);
        }
    }
    private void getFieldReceiptReference(JSONObject objectField, Response responseObject) {
        String receiptReference = objectField.optString(ResponseFieldsList.ReceiptReference.getString());
        if(!receiptReference.isEmpty())
        {
            responseObject.setReceiptReference(receiptReference);
        }
    }
    private void getFieldRRN (JSONObject objectField, Response responseObject) {
        String rrn = objectField.optString(ResponseFieldsList.RRN.getString());
        if(!rrn.isEmpty())
        {
            responseObject.setRRN(rrn);
        }
    }
    private void getFieldStatus(JSONObject objectField, Response responseObject) {
        int status = objectField.optInt(ResponseFieldsList.Status.getString(), -1);
        if(status != -1)
        {
            responseObject.setStatus(StatusList.getValue(status));
        }
    }
    private void getFieldOriginalOperationStatus(JSONObject objectField, Response responseObject) {
        int originalOperationStatus = objectField.optInt(ResponseFieldsList.OriginalOperationStatus.getString(), -1);
        if(originalOperationStatus != -1)
        {
            responseObject.setOriginalOperationStatus(StatusList.getValue(originalOperationStatus));
        }
    }
    private void getFieldTransDateTime(JSONObject objectField, Response responseObject) {
        String transactionDateTime = objectField.optString(ResponseFieldsList.TransDateTime.getString());
        if(!transactionDateTime.isEmpty())
        {
            responseObject.setTransDateTime(transactionDateTime);
        }
    }
    private void getFieldTerminalDateTime(JSONObject objectField, Response responseObject) {
        String terminalDateTime = objectField.optString(ResponseFieldsList.TerminalDateTime.getString());
        if(!terminalDateTime.isEmpty())
        {
            responseObject.setTerminalDateTime(terminalDateTime);
        }
    }
    private void getFieldCardPAN(JSONObject objectField, Response responseObject) {
        String cardPan = objectField.optString(ResponseFieldsList.CardPAN.getString());
        if(!cardPan.isEmpty())
        {
            responseObject.setCardPAN(cardPan);
        }
    }
    private void getFieldExpireDate(JSONObject objectField, Response responseObject) {
        String expireDate = objectField.optString(ResponseFieldsList.ExpireDate.getString());
        if(!expireDate.isEmpty())
        {
            responseObject.setExpireDate(expireDate);
        }
    }
    private void getFieldCardholderName(JSONObject objectField, Response responseObject) {
        String cardholderName = objectField.optString(ResponseFieldsList.CardholderName.getString());
        if(!cardholderName.isEmpty())
        {
            responseObject.setCardholderName(cardholderName);
        }
    }
    private void getFieldCardholderAuthMethod(JSONObject objectField, Response responseObject) {
        int cardholderAuthMethod = objectField.optInt(ResponseFieldsList.CardholderAuthMethod.getString(), -1);
        if(cardholderAuthMethod != -1)
        {
            responseObject.setCardholderAuthMethod(CardholderAuthMethodList.getValue(cardholderAuthMethod));
        }
    }
    private void getFieldAuthCode(JSONObject objectField, Response responseObject) {
        String authCode = objectField.optString(ResponseFieldsList.AuthCode.getString());
        if(!authCode.isEmpty())
        {
            responseObject.setAuthCode(authCode);
        }
    }
    private void getFieldResponseCode(JSONObject objectField, Response responseObject) {
        String responseCode = objectField.optString(ResponseFieldsList.ResponseCode.getString());
        if(!responseCode.isEmpty())
        {
            responseObject.setResponseCode(responseCode);
        }
    }
    private void getFieldResponseText(JSONObject objectField, Response responseObject) {
        String responseText = objectField.optString(ResponseFieldsList.ResponseText.getString());
        if(!responseText.isEmpty())
        {
            responseObject.setResponseText(responseText);
        }
    }
    private void getFieldSTAN(JSONObject objectField, Response responseObject) {
        String stan = objectField.optString(ResponseFieldsList.STAN.getString());
        if(!stan.isEmpty())
        {
            responseObject.setSTAN(stan);
        }
    }
    private void getFieldTransactionID(JSONObject objectField, Response responseObject) {
        String transactionID = objectField.optString(ResponseFieldsList.TransactionID.getString());
        if(!transactionID.isEmpty())
        {
            responseObject.setTransactionID(transactionID);
        }
    }
    private void getFieldTerminalID(JSONObject objectField, Response responseObject) {
        String terminalID = objectField.optString(ResponseFieldsList.TerminalID.getString());
        if(!terminalID.isEmpty())
        {
            responseObject.setTerminalID(terminalID);
        }
    }
    private void getFieldCardEmvAid(JSONObject objectField, Response responseObject) {
        String cardEMVAid = objectField.optString(ResponseFieldsList.CardEmvAid.getString());
        if(!cardEMVAid.isEmpty())
        {
            responseObject.setCardEmvAid(cardEMVAid);
        }
    }
    private void getFieldCardAppName(JSONObject objectField, Response responseObject) {
        String cardAppName = objectField.optString(ResponseFieldsList.CardAppName.getString());
        if(!cardAppName.isEmpty())
        {
            responseObject.setCardAppName(cardAppName);
        }
    }
    private void getFieldCardInputMethod(JSONObject objectField, Response responseObject) {
        int cardInputMethod = objectField.optInt(ResponseFieldsList.CardInputMethod.getString(), -1);
        if(cardInputMethod != -1)
        {
            responseObject.setCardInputMethod(CardInputMethodList.getValue(cardInputMethod));
        }
    }
    private void getFieldIssuerName(JSONObject objectField, Response responseObject) {
        String issuerName = objectField.optString(ResponseFieldsList.IssuerName.getString());
        if(!issuerName.isEmpty())
        {
            responseObject.setIssuerName(issuerName);
        }
    }
    private void getFieldAdditionalInfo(JSONObject objectField, Response responseObject) {
        String additionalInfo = objectField.optString(ResponseFieldsList.AdditionalInfo.getString());
        if(!additionalInfo.isEmpty())
        {
            responseObject.setAdditionalInfo(additionalInfo);
        }
    }
    private void getFieldCardDataEnc(JSONObject objectField, Response responseObject) {
        String cardDataEnc = objectField.optString(ResponseFieldsList.CardDataEnc.getString());
        if(!cardDataEnc.isEmpty())
        {
            responseObject.setCardDataEnc(cardDataEnc);
        }
    }
    private void getFieldMerchantId(JSONObject objectField, Response responseObject) {
        String merchantID = objectField.optString(ResponseFieldsList.MerchantId.getString());
        if(!merchantID.isEmpty())
        {
            responseObject.setMerchantId(merchantID);
        }
    }
    private void getFieldTVR (JSONObject objectField, Response responseObject) {
        String tvr = objectField.optString(ResponseFieldsList.TVR.getString());
        if(!tvr.isEmpty())
        {
            responseObject.setTVR(tvr);
        }
    }
    private void getFieldTSI (JSONObject objectField, Response responseObject) {
        String tsi = objectField.optString(ResponseFieldsList.TSI.getString());
        if(!tsi.isEmpty())
        {
            responseObject.setTSI(tsi);
        }
    }
    private void getFieldTC(JSONObject objectField, Response responseObject) {
        String tc = objectField.optString(ResponseFieldsList.TC.getString());
        if(!tc.isEmpty())
        {
            responseObject.setTC(tc);
        }
    }
    private void getFieldCID (JSONObject objectField, Response responseObject) {
        String cid = objectField.optString(ResponseFieldsList.CID.getString());
        if(!cid.isEmpty())
        {
            responseObject.setCID(cid);
        }
    }
    private void getFieldKVR (JSONObject objectField, Response responseObject) {
        String kvr = objectField.optString(ResponseFieldsList.KVR.getString());
        if(!kvr.isEmpty())
        {
            responseObject.setKVR(kvr);
        }
    }
    private void getFieldCDAResult(JSONObject objectField, Response responseObject) {
        String cdaResult = objectField.optString(ResponseFieldsList.CDAResult.getString());
        if(!cdaResult.isEmpty())
        {
            responseObject.setCDAResult(cdaResult);
        }
    }
    private void getFieldSalesCount (JSONObject objectField, Response responseObject) {
        int salesCount = objectField.optInt(ResponseFieldsList.SalesCount.getString(), -1);
        if(salesCount != -1)
        {
            responseObject.setSalesCount(salesCount);
        }
    }
    private void getFieldVoidCount(JSONObject objectField, Response responseObject) {
        int voidCount = objectField.optInt(ResponseFieldsList.VoidCount.getString(), -1);
        if(voidCount != -1)
        {
            responseObject.setVoidCount(voidCount);
        }
    }
    private void getFieldRefundCount(JSONObject objectField, Response responseObject) {
        int refundCount = objectField.optInt(ResponseFieldsList.RefundCount.getString(), -1);
        if(refundCount != -1)
        {
            responseObject.setRefundCount(refundCount);
        }
    }
    private void getFieldSalesArray (JSONObject objectField, Response responseObject) {
        responseObject.setSalesArray(parseArray(ResponseFieldsList.SalesArray.getString(), objectField));
    }
    private void getFieldVoidArray(JSONObject objectField, Response responseObject) {
        responseObject.setVoidArray(parseArray(ResponseFieldsList.SalesArray.getString(), objectField));
    }
    private void getFieldRefundArray(JSONObject objectField, Response responseObject) {
        responseObject.setRefundArray(parseArray(ResponseFieldsList.RefundArray.getString(), objectField));
    }

    private Set<Response> parseArray(String arrayName, JSONObject objectField) {
        Set<Response> array = new HashSet<>();
        if(objectField.has(arrayName)){
            JSONArray jsonArray = objectField.getJSONArray(arrayName);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentObject = jsonArray.getJSONObject(i);
                Response arrayStubOperation = new ArrayStubOperation();
                getFields(arrayStubOperation.getMandatoryFields(), currentObject, arrayStubOperation);
                if(arrayStubOperation.checkMandatoryFields()) {
                    array.add(arrayStubOperation);
                }
            }
        }
        return array;
    }
}
