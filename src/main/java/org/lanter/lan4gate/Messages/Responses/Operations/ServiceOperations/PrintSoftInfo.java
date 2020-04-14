package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

public class PrintSoftInfo extends Response {
    public PrintSoftInfo() {
        setOperationCode(OperationsList.PrintSoftInfo);
        addMandatoryFields(ResponseFieldsList.AdditionalInfo);
    }
}
