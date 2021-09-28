package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Response.IResponse;
import org.lanter.lan4gate.Messages.Response.ResponseFactory;
import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class GetLastOperation extends Response {
   public GetLastOperation(OperationsList operationCode) {
       setOperationCode(OperationsList.GetLastOperation);
       addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
       addOptionalFields(ResponseFieldsList.OriginalOperationCode);
       addOptionalFields(ResponseFieldsList.OriginalOperationStatus);

       //Так как неизвестна операция, то необходимо забрать поля из используемой
       if (!operationCode.equals(OperationsList.GetLastOperation)) {
           IResponse operation = ResponseFactory.getResponse(operationCode);
           if (operation != null) {
               addMandatoryFieldsGroup(operation.getMandatoryFields());
               addOptionalFieldsGroup(operation.getOptionalFields());
           }
       }
   }
}
