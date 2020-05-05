package org.lanter.lan4gate.Implementation.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Requests.Request;

public class GetLastOperation extends Request {
   public GetLastOperation() {
       setOperationCode(OperationsList.GetLastOperation);
       addOptionalFields(RequestFieldsList.EcrMerchantNumber);
   }
}
