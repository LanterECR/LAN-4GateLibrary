package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Request.Request;
import org.lanter.lan4gate.Messages.OperationsList;

public class ClearReversal extends Request {
    public ClearReversal() {
        setOperationCode(OperationsList.ClearReversal);
    }
}
