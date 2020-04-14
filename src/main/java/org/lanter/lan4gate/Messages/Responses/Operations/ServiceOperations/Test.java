package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.Responses.Response;

public class Test extends Response {
    public Test() {
        setOperationCode(OperationsList.Test);
    }
}
