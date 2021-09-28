package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class TestCommunication extends Response {
    public TestCommunication() {
        setOperationCode(OperationsList.TestCommunication);
    }
}
