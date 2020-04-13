package org.lanter.lan4gate.Messages.Requests.Assembler;

import org.json.JSONObject;
import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.Fields.RootFields;
import org.lanter.lan4gate.Messages.MessageClassList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class JSONAssembler {
    Request mRequest;
    String mJsonString;
    public boolean assemble(Request request) {
        if(request != null && request.checkMandatoryFields()) {
            mRequest = request;
            JSONObject root = new JSONObject();
            createClassField(root);
            createObjectField(root);
            mJsonString = root.toString();
            return !mJsonString.isEmpty();
        }
        return false;
    }
    public String getJson() {
        return mJsonString;
    }
    private void createClassField(JSONObject root) {
        root.put(RootFields.CLASS, MessageClassList.Request.getString());
    }
    private void createObjectField(JSONObject root) {
        JSONObject object = new JSONObject();
        addObjectFields(object);
        root.put(RootFields.OBJECT, object);
    }
    private void addObjectFields(JSONObject object) {
        if(mRequest != null && object != null) {
            for (RequestFieldsList field : mRequest.getFields()) {
                switch (field)
                {
                    case EcrNumber:{
                        object.put(field.getString(), mRequest.getEcrNumber());
                        break;
                    }
                    case EcrMerchantNumber:{
                        object.put(field.getString(), mRequest.getEcrMerchantNumber());
                        break;
                    }
                    case OperationCode:{
                        object.put(field.getString(), mRequest.getOperationCode().getNumber());
                        break;
                    }
                    case Amount:{
                        object.put(field.getString(), mRequest.getAmount());
                        break;
                    }
                    case TipsAmount:{
                        object.put(field.getString(), mRequest.getTipsAmount());
                        break;
                    }
                    case CashbackAmount:{
                        object.put(field.getString(), mRequest.getCashbackAmount());
                        break;
                    }
                    case CurrencyCode:{
                        object.put(field.getString(), mRequest.getCurrencyCode());
                        break;
                    }
                    case RRN:{
                        object.put(field.getString(), mRequest.getRRN());
                        break;
                    }
                    case AuthCode:{
                        object.put(field.getString(), mRequest.getAuthCode());
                        break;
                    }
                    case ReceiptReference:{
                        object.put(field.getString(), mRequest.getReceiptReference());
                        break;
                    }
                    case TransactionID:{
                        object.put(field.getString(), mRequest.getTransactionID());
                        break;
                    }
                    case CardDataEnc:{
                        object.put(field.getString(), mRequest.getCardDataEnc());
                        break;
                    }
                    case OpenTags:{
                        object.put(field.getString(), mRequest.getOpenTags());
                        break;
                    }
                    case EncTags:{
                        object.put(field.getString(), mRequest.getEncTags());
                        break;
                    }
                    case ProviderCode:{
                        object.put(field.getString(), mRequest.getProviderCode());
                        break;
                    }
                    case AdditionalInfo:{
                        object.put(field.getString(), mRequest.getAdditionalInfo());
                        break;
                    }
                }
            }
        }
    }
}
