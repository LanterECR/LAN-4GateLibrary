package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class PrintSoftInfo extends Response {
    public PrintSoftInfo() {
        setOperationCode(OperationsList.PrintSoftInfo);
        addOptionalFields(ResponseFieldsList.AdditionalInfo);
    }
}
