package org.lanter.lan4gate.Implementation.MessageProcessor.Builder;

import org.json.JSONException;
import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.RootFields;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Request.IRequest;
import org.lanter.lan4gate.Messages.Request.RequestFieldsList;

import java.util.Set;

public class JSONRequestBuilder {
    public static boolean createObject(JSONObject root, IRequest request) throws JSONException {
        JSONObject object = new JSONObject();
        addObjectFields(object, request);

        boolean result = object.length() > 0;
        if(result) {
            root.put(RootFields.OBJECT, object);
        }
        return result;
    }

    private static void addObjectFields(JSONObject object, IRequest request) throws JSONException {
        if(request != null) {
            addFields(object, request.getMandatoryFields(), request);
            addFields(object, request.getOptionalFields(), request);
        }
    }
    private static void addFields(JSONObject object, final Set<RequestFieldsList> fields, IRequest request) throws JSONException {
        if(fields != null && object != null) {
            for (RequestFieldsList field : fields) {
                switch (field)
                {
                    case EcrNumber:{
                        if(request.getEcrNumber() > 0) {
                            object.put(field.getString(), request.getEcrNumber());
                        }
                        break;
                    }
                    case EcrMerchantNumber:{
                        if(request.getEcrMerchantNumber() > 0) {
                            object.put(field.getString(), request.getEcrMerchantNumber());
                        }
                        break;
                    }
                    case OperationCode:{
                        if(request.getOperationCode() != null && request.getOperationCode() != OperationsList.NoOperation) {
                            object.put(field.getString(), request.getOperationCode().getNumber());
                        }
                        break;
                    }
                    case Amount:{
                        if(request.getAmount() > 0) {
                            object.put(field.getString(), request.getAmount());
                        }
                        break;
                    }
                    case PartialAmount: {
                        if(request.getPartialAmount() > 0) {
                            object.put(field.getString(), request.getPartialAmount());
                        }
                        break;
                    }
                    case TipsAmount:{
                        if(request.getTipsAmount() > 0) {
                            object.put(field.getString(), request.getTipsAmount());
                        }
                        break;
                    }
                    case CashbackAmount:{
                        if(request.getCashbackAmount() > 0) {
                            object.put(field.getString(), request.getCashbackAmount());
                        }
                        break;
                    }
                    case CurrencyCode:{
                        if(request.getCurrencyCode() > 0) {
                            object.put(field.getString(), request.getCurrencyCode());
                        }
                        break;
                    }
                    case RRN:{
                        object.put(field.getString(), request.getRRN());
                        break;
                    }
                    case AuthCode:{
                        object.put(field.getString(), request.getAuthCode());
                        break;
                    }
                    case ReceiptReference:{
                        object.put(field.getString(), request.getReceiptReference());
                        break;
                    }
                    case TransactionID:{
                        object.put(field.getString(), request.getTransactionID());
                        break;
                    }
                    case CardDataEnc:{
                        object.put(field.getString(), request.getCardDataEnc());
                        break;
                    }
                    case OpenTags:{
                        object.put(field.getString(), request.getOpenTags());
                        break;
                    }
                    case EncTags:{
                        object.put(field.getString(), request.getEncTags());
                        break;
                    }
                    case ProviderCode:{
                        object.put(field.getString(), request.getProviderCode());
                        break;
                    }
                    case AdditionalInfo:{
                        object.put(field.getString(), request.getAdditionalInfo());
                        break;
                    }
                }
            }
        }
    }
}
