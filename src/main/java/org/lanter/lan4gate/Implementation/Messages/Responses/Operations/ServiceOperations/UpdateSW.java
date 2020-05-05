package org.lanter.lan4gate.Implementation.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Responses.Response;

public class UpdateSW extends Response {
    public UpdateSW() {
        setOperationCode(OperationsList.UpdateSW);
    }
}
