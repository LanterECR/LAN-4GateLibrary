package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;

public class KeyDownload extends Request {
    public KeyDownload() {
        setOperationCode(OperationsList.KeyDownload);
    }
}
