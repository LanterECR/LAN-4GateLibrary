package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class GetCurrentPrinter extends Response {
    public GetCurrentPrinter() {
        setOperationCode(OperationsList.GetCurrentPrinter);
        addOptionalFields(ResponseFieldsList.AdditionalInfo);
    }
}
