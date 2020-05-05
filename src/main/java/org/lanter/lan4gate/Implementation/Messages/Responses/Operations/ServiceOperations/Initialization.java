package org.lanter.lan4gate.Implementation.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Responses.Response;

public class Initialization extends Response {
    public Initialization() {
        setOperationCode(OperationsList.Initialization);
    }
}
