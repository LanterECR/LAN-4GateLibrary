package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

public class KeyDownload extends Response {
    public KeyDownload() {
        setOperationCode(OperationsList.KeyDownload);
    }
}
