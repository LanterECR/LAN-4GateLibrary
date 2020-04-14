package org.lanter.lan4gate.Messages.Responses;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Responses.Operations.RefundOperations.Refund;
import org.lanter.lan4gate.Messages.Responses.Operations.RefundOperations.RefundWithoutRRN;
import org.lanter.lan4gate.Messages.Responses.Operations.SaleOperations.*;
import org.lanter.lan4gate.Messages.Responses.Operations.VoidOperations.FullVoid;
import org.lanter.lan4gate.Messages.Responses.Operations.VoidOperations.VoidPartialSale;
import org.lanter.lan4gate.Messages.Responses.Operations.VoidOperations.VoidPreAuth;

public class ResponseBuilder {
    public Response prepareResponse(OperationsList operation) {
        Response result = null;
        switch (operation) {
            case Sale: {
                result = new Sale();
                break;
            }
            case MOTO: {
                result = new MOTO();
                break;
            }
            case QuickPayment: {
                result = new QuickPayment();
                break;
            }
            case PreAuth: {
                result = new PreAuth();
                break;
            }
            case SalesCompletion: {
                result = new SalesCompletion();
                break;
            }
            case FastTrack: {
                result = new FastTrack();
                break;
            }
            case Void: {
                result = new FullVoid();
                break;
            }
            case VoidPartialSale: {
                result = new VoidPartialSale();
                break;
            }
            case VoidPreAuth: {
                result = new VoidPreAuth();
                break;
            }
            case Refund: {
                result = new Refund();
                break;
            }
            case RefundWithoutRRN: {
                result = new RefundWithoutRRN();
                break;
            }
            case Registration:
            case TestCommunication:
            case Test:
            case PrintLastReceipt:
            case GetLastOperation:
            case PrintReceiptCopy:
            case PrintDetailReport:
            case PrintSummaryReport:
            case Settlement:
            case KeyDownload:
            case Initialization:
            case UpdateSW:
            case PrintCommsInfo:
            case PrintSoftInfo:
            case FinalizeTransaction:
            case GetCurrentPrinter:
            case SetCurrentPrinter:
            default: {
                break;
            }
        }
        return result;
    }
}
