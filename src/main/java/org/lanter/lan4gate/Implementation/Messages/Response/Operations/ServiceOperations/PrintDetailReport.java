package org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Response.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;

public class PrintDetailReport extends Response {
    public PrintDetailReport() {
        setOperationCode(OperationsList.PrintDetailReport);

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
        addOptionalFields(ResponseFieldsList.SalesArray);
        addOptionalFields(ResponseFieldsList.VoidArray);
        addOptionalFields(ResponseFieldsList.RefundArray);
    }
}
