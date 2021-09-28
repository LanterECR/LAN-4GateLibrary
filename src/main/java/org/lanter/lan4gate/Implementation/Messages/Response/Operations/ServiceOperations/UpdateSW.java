package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class UpdateSW extends Response {
    public UpdateSW() {
        setOperationCode(OperationsList.UpdateSW);
    }
}
