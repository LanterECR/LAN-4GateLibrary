package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Request.Request;
import org.lanter.lan4gate.Messages.OperationsList;

public class ClearAllJournals extends Request {
    public ClearAllJournals() {
        setOperationCode(OperationsList.ClearAllJournals);
    }
}
