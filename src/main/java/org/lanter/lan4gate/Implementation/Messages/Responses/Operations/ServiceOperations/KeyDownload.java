package org.lanter.lan4gate.Implementation.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Responses.Response;

public class KeyDownload extends Response {
    public KeyDownload() {
        setOperationCode(OperationsList.KeyDownload);
    }
}
