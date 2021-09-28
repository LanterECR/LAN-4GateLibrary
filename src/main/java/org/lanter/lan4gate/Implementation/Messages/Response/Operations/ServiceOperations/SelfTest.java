package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class SelfTest extends Response {
    public SelfTest() {
        setOperationCode(OperationsList.SelfTest);
    }
}
