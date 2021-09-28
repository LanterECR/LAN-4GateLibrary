package org.lanter.lan4gate.Messages.Request;

import org.lanter.lan4gate.Implementation.Messages.Request.Operations.RefundOperations.Refund;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.RefundOperations.RefundWithoutRRN;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.SaleOperations.FastTrack;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.SaleOperations.MOTO;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.SaleOperations.PreAuth;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.SaleOperations.QuickPayment;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.SaleOperations.Sale;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.SaleOperations.SalesCompletion;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.ClearAllJournals;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.ClearReversal;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.DisplayQR;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.FinalizeTransaction;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.GetCurrentPrinter;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.GetLastOperation;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.GetOperationCopy;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.Initialization;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.KeyDownload;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.LicenceActivationFile;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.LicenceActivationServer;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.PrintCommsInfo;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.PrintDetailReport;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.PrintLastReceipt;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.PrintReceiptCopy;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.PrintSoftInfo;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.PrintSummaryReport;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.Registration;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.SelfTest;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.SendLogs;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.SetCurrentPrinter;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.SetLogLevel;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.Settlement;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.Test;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.TestCommunication;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.ServiceOperations.UpdateSW;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.VoidOperations.FullVoid;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.VoidOperations.VoidPartialSale;
import org.lanter.lan4gate.Implementation.Messages.Request.Operations.VoidOperations.VoidPreAuth;
import org.lanter.lan4gate.Implementation.Messages.Request.Request;
import org.lanter.lan4gate.Messages.OperationsList;

public class RequestFactory {
    public static IRequest getRequest(OperationsList operation) {
        return getRequest(operation, 0);
    }
    public static IRequest getRequest(OperationsList operation, int ecrNumber) {
        Request result = null;
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
                result = new PrintLastReceipt();
                break;
            }
            case GetLastOperation: {
                result = new GetLastOperation();
                break;
            }
            case PrintReceiptCopy: {
                result = new PrintReceiptCopy();
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
                result = new GetOperationCopy();
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
        if(result != null && ecrNumber > 0) {
            result.setEcrNumber(ecrNumber);
        }
        return result;
    }
}
