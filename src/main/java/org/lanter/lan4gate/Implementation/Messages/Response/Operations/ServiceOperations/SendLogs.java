package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Response.Response;
import org.lanter.lan4gate.Messages.OperationsList;

public class SendLogs extends Response {
    public SendLogs() {
        setOperationCode(OperationsList.SendLogs);
    }
}
