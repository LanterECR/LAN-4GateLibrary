package org.lanter.lan4gate.Implementation.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Requests.Request;

public class UpdateSW extends Request {
    public UpdateSW() {
        setOperationCode(OperationsList.UpdateSW);
    }
}
