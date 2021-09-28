package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class Test extends Request {
    public Test() {
        setOperationCode(OperationsList.Test);
        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
    }
}
