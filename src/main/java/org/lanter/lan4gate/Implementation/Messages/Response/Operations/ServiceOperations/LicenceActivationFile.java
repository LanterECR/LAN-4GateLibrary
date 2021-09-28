package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Response.Response;
import org.lanter.lan4gate.Messages.OperationsList;

public class LicenceActivationFile extends Response {
    public LicenceActivationFile() {
        setOperationCode(OperationsList.LicenceActivationFile);
    }
}
