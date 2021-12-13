package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class PrintSummaryReport extends Response {
    public PrintSummaryReport() {
        setOperationCode(OperationsList.PrintSummaryReport);
        addOptionalFields(ResponseFieldsList.EcrMerchantNumber);

        addOptionalFields(ResponseFieldsList.TerminalID);

        addOptionalFields(ResponseFieldsList.TotalAmount);
        addOptionalFields(ResponseFieldsList.CurrencyCode);
        addOptionalFields(ResponseFieldsList.TerminalDateTime);
        addOptionalFields(ResponseFieldsList.SalesAmount);
        addOptionalFields(ResponseFieldsList.VoidAmount);
        addOptionalFields(ResponseFieldsList.RefundAmount);
        addOptionalFields(ResponseFieldsList.SalesCount);
        addOptionalFields(ResponseFieldsList.VoidCount);
        addOptionalFields(ResponseFieldsList.RefundCount);
    }
}
