package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;
import org.lanter.lan4gate.Messages.Responses.ResponseBuilder;

public class Settlement extends Response {
    public Settlement() {
        setOperationCode(OperationsList.Settlement);
        addMandatoryFields(ResponseFieldsList.EcrMerchantNumber);

        ResponseBuilder builder = new ResponseBuilder();
        Response operation = builder.prepareResponse(OperationsList.PrintDetailReport);
        if(operation != null) {
            addMandatoryFieldsGroup(operation.getMandatoryFields());
            addOptionalFieldsGroup(operation.getOptionalFields());
        }
    }
}
