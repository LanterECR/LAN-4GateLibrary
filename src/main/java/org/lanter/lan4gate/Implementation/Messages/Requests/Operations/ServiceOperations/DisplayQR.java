package org.lanter.lan4gate.Implementation.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Implementation.Messages.Requests.Request;
import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;

public class DisplayQR extends Request {
    public DisplayQR() {
        setOperationCode(OperationsList.DisplayQR);
        addMandatoryFields(RequestFieldsList.AdditionalInfo);
    }
}
