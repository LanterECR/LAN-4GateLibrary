package org.lanter.lan4gate.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class UpdateSW extends Request {
    public UpdateSW() {
        setOperationCode(OperationsList.UpdateSW);
    }
}