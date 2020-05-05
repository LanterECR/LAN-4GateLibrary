package org.lanter.lan4gate.Implementation.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Requests.Request;

public class GetCurrentPrinter extends Request {
    public GetCurrentPrinter() {
        setOperationCode(OperationsList.GetCurrentPrinter);
    }
}
