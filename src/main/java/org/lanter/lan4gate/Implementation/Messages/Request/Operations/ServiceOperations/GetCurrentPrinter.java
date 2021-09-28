package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class GetCurrentPrinter extends Request {
    public GetCurrentPrinter() {
        setOperationCode(OperationsList.GetCurrentPrinter);
    }
}
