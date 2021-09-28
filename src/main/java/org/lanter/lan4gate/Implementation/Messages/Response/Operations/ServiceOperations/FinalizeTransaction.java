package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class FinalizeTransaction extends Response {
    public FinalizeTransaction() {
        setOperationCode(OperationsList.FinalizeTransaction);
    }
}
