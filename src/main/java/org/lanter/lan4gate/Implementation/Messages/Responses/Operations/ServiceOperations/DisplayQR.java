package org.lanter.lan4gate.Implementation.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Responses.Response;
import org.lanter.lan4gate.Messages.OperationsList;

public class DisplayQR extends Response {
    public DisplayQR() {
        setOperationCode(OperationsList.DisplayQR);
    }
}
