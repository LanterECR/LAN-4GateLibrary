package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Request.Request;
import org.lanter.lan4gate.Messages.OperationsList;

public class LicenceActivationServer extends Request {
    public LicenceActivationServer() {
        setOperationCode(OperationsList.LicenceActivationServer);
    }
}
