package org.lanter.lan4gate.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Response;

public class PrintSummaryReport extends Response {
    public PrintSummaryReport() {
        setOperationCode(OperationsList.PrintSummaryReport);
        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);

        addOptionalFields(ResponseFieldsList.TerminalID);

        addOptionalFields(ResponseFieldsList.TotalAmount);
        addOptionalFields(ResponseFieldsList.CurrencyCode);
        addOptionalFields(ResponseFieldsList.TerminalDateTime);
        addOptionalFields(ResponseFieldsList.SalesCount);
        addOptionalFields(ResponseFieldsList.VoidCount);
        addOptionalFields(ResponseFieldsList.RefundCount);
    }
}
