package org.lanter.lan4gate.Messages.Requests.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Request;

public class PrintSummaryReport extends Request {
    public PrintSummaryReport() {
        setOperationCode(OperationsList.PrintSummaryReport);
        addOptionalFields(RequestFieldsList.EcrMerchantNumber);
    }
}
