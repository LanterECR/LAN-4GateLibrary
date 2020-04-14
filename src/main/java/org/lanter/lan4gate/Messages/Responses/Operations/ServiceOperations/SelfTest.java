package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

public class SelfTest extends Response {
    public SelfTest() {
        setOperationCode(OperationsList.SelfTest);
    }
}
