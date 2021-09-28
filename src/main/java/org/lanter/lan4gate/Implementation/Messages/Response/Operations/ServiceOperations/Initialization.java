package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class Initialization extends Response {
    public Initialization() {
        setOperationCode(OperationsList.Initialization);
    }
}
