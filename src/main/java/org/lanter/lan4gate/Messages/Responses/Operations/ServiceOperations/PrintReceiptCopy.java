package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.Responses.Response;
import org.lanter.lan4gate.Messages.Responses.ResponseBuilder;

public class PrintReceiptCopy extends Response {
    public PrintReceiptCopy(OperationsList operationCode) {
        setOperationCode(OperationsList.PrintReceiptCopy);
        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
        addMandatoryFields(ResponseFieldsList.OriginalOperationCode);
        addMandatoryFields(ResponseFieldsList.OriginalOperationStatus);

        //Так как неизвестна операция, то необходимо забрать поля из используемой
        if(!operationCode.equals(OperationsList.PrintReceiptCopy)) {
            ResponseBuilder builder = new ResponseBuilder();
            Response operation = builder.prepareResponse(operationCode);
            if(operation != null) {
                addMandatoryFieldsGroup(operation.getMandatoryFields());
                addOptionalFieldsGroup(operation.getOptionalFields());
            }
        }
    }
}
