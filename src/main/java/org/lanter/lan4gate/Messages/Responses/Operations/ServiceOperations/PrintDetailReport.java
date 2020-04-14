package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

public class PrintDetailReport extends Response {
    public PrintDetailReport() {
        setOperationCode(OperationsList.PrintDetailReport);

        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
        addMandatoryFields(ResponseFieldsList.TerminalID);

        addOptionalFields(ResponseFieldsList.TotalAmount);
        addOptionalFields(ResponseFieldsList.CurrencyCode);
        addOptionalFields(ResponseFieldsList.TerminalDateTime);
        addOptionalFields(ResponseFieldsList.SalesCount);
        addOptionalFields(ResponseFieldsList.VoidCount);
        addOptionalFields(ResponseFieldsList.RefundCount);
        addOptionalFields(ResponseFieldsList.SalesArray);
        addOptionalFields(ResponseFieldsList.VoidArray);
        addOptionalFields(ResponseFieldsList.RefundArray);
    }
}
