package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Request.Request;
import org.lanter.lan4gate.Messages.OperationsList;

public class SendLogs extends Request {
    public SendLogs() {
        setOperationCode(OperationsList.SendLogs);
    }
}
