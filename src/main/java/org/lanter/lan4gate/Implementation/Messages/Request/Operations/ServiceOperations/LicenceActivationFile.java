package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Request.Request;
import org.lanter.lan4gate.Messages.OperationsList;

public class LicenceActivationFile extends Request {
    public LicenceActivationFile() {
        setOperationCode(OperationsList.LicenceActivationFile);
    }
}
