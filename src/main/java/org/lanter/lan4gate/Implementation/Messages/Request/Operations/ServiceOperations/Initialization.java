package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class Initialization extends Request {
    public Initialization() {
        setOperationCode(OperationsList.Initialization);
    }
}
