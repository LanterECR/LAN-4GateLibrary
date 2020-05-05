package org.lanter.lan4gate.Implementation.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Requests.Request;

public class PrintSoftInfo extends Request {
    public PrintSoftInfo() {
        setOperationCode(OperationsList.PrintSoftInfo);
    }
}
