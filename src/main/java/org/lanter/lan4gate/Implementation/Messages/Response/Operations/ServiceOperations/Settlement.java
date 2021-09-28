package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Response.IResponse;
import org.lanter.lan4gate.Messages.Response.ResponseFactory;
import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class Settlement extends Response {
    public Settlement() {
        setOperationCode(OperationsList.Settlement);
        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);

        IResponse operation = ResponseFactory.getResponse(OperationsList.PrintDetailReport);
        if(operation != null) {
            addMandatoryFieldsGroup(operation.getMandatoryFields());
            addOptionalFieldsGroup(operation.getOptionalFields());
        }
    }
}
