package org.lanter.lan4gate.Implementation.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.OperationsList;

public class ClearReversal extends Request {
    public ClearReversal() {
        setOperationCode(OperationsList.ClearReversal);
    }
}
