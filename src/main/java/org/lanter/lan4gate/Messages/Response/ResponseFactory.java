package org.lanter.lan4gate.Messages.Response;

import org.lanter.lan4gate.Implementation.Messages.Response.Operations.SaleOperations.*;
import org.lanter.lan4gate.Implementation.Messages.Response.Operations.VoidOperations.*;
import org.lanter.lan4gate.Implementation.Messages.Response.Operations.RefundOperations.*;
import org.lanter.lan4gate.Implementation.Messages.Response.Operations.ServiceOperations.*;
import org.lanter.lan4gate.Implementation.Messages.Response.Response;
import org.lanter.lan4gate.Messages.OperationsList;

public class ResponseFactory {
    public static IResponse getResponse(OperationsList operation) {
        return getResponse(operation, OperationsList.NoOperation);
    }
    public static IResponse getResponse(OperationsList operation, OperationsList originalOperation) {
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
            case Registration: {
                result = new Registration();
                break;
            }
            case TestCommunication:{
                result = new TestCommunication();
                break;
            }
            case Test: {
                result = new Test();
                break;
            }
            case PrintLastReceipt: {
                result = new PrintLastReceipt(originalOperation);
                break;
            }
            case GetLastOperation: {
                result = new GetLastOperation(originalOperation);
                break;
            }
            case PrintReceiptCopy: {
                result = new PrintReceiptCopy(originalOperation);
                break;
            }
            case PrintDetailReport: {
                result = new PrintDetailReport();
                break;
            }
            case PrintSummaryReport: {
                result = new PrintSummaryReport();
                break;
            }
            case Settlement: {
                result = new Settlement();
                break;
            }
            case KeyDownload: {
                result = new KeyDownload();
                break;
            }
            case Initialization: {
                result = new Initialization();
                break;
            }
            case UpdateSW: {
                result = new UpdateSW();
                break;
            }
            case PrintCommsInfo: {
                result = new PrintCommsInfo();
                break;
            }
            case PrintSoftInfo: {
                result = new PrintSoftInfo();
                break;
            }
            case FinalizeTransaction: {
                result = new FinalizeTransaction();
                break;
            }
            case GetCurrentPrinter: {
                result = new GetCurrentPrinter();
                break;
            }
            case SetCurrentPrinter: {
                result = new SetCurrentPrinter();
                break;
            }
            case SelfTest: {
                result = new SelfTest();
                break;
            }
            case GetOperationCopy:
                result = new GetOperationCopy(originalOperation);
                break;
            case DisplayQR:
                result = new DisplayQR();
                break;
            case SendLogs:
                result = new SendLogs();
                break;
            case SetLogLevel:
                result = new SetLogLevel();
                break;
            case LicenceActivationFile:
                result = new LicenceActivationFile();
                break;
            case LicenceActivationServer:
                result = new LicenceActivationServer();
                break;
            case ClearReversal:
                result = new ClearReversal();
                break;
            case ClearAllJournals:
                result = new ClearAllJournals();
                break;
        }
        return result;
    }
}
