package org.lanter.lan4gate.Implementation.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;

public class SetLogLevel extends Request {
    public SetLogLevel() {
        setOperationCode(OperationsList.SetLogLevel);
        addMandatoryFields(RequestFieldsList.AdditionalInfo);
    }
}