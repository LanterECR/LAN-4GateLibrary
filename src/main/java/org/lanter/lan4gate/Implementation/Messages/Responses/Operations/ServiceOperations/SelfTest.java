package org.lanter.lan4gate.Implementation.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Responses.Response;

public class SelfTest extends Response {
    public SelfTest() {
        setOperationCode(OperationsList.SelfTest);
    }
}
