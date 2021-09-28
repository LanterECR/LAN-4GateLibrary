package org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Request.Request;
import org.lanter.lan4gate.Messages.Request.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;

public class SetLogLevel extends Request {
    public SetLogLevel() {
        setOperationCode(OperationsList.SetLogLevel);
        addMandatoryFields(RequestFieldsList.AdditionalInfo);
    }
}