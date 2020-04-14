package org.lanter.lan4gate.Messages.Requests;

import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Operations.RefundOperations.Refund;
import org.lanter.lan4gate.Messages.Requests.Operations.RefundOperations.RefundWithoutRRN;
import org.lanter.lan4gate.Messages.Requests.Operations.SaleOperations.*;
import org.lanter.lan4gate.Messages.Requests.Operations.VoidOperations.FullVoid;
import org.lanter.lan4gate.Messages.Requests.Operations.VoidOperations.VoidPartialSale;
import org.lanter.lan4gate.Messages.Requests.Operations.VoidOperations.VoidPreAuth;

public class RequestBuilder {
    private final int mEcrNumber;

    public RequestBuilder(int ecrNumber) {
        mEcrNumber = ecrNumber;
    }

    Request prepareRequest(OperationsList operation) throws UnsupportedOperationException {
        Request result;
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
                throw new UnsupportedOperationException("Operation " + operation.name() + " not supported yet");
            }
        }
        result.setEcrNumber(mEcrNumber);
        return result;
    }
}
