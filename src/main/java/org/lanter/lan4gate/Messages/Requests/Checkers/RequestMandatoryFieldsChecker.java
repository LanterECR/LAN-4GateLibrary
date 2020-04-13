package org.lanter.lan4gate.Messages.Requests.Checkers;

import org.lanter.lan4gate.Messages.Fields.RequestFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Requests.Checkers.RefundOperations.Refund;
import org.lanter.lan4gate.Messages.Requests.Checkers.RefundOperations.RefundWithoutRRN;
import org.lanter.lan4gate.Messages.Requests.Checkers.SaleOperations.*;
import org.lanter.lan4gate.Messages.Requests.Checkers.VoidOperations.VoidPartialSale;
import org.lanter.lan4gate.Messages.Requests.Checkers.VoidOperations.VoidPreAuth;
import org.lanter.lan4gate.Messages.Requests.Checkers.VoidOperations.VoidSale;

import java.util.ArrayList;
import java.util.List;

public class RequestMandatoryFieldsChecker {
    private List<RequestFieldsList> mMandatoryFieldsList = new ArrayList<>();
    protected void addMandatoryFields(RequestFieldsList field) {
        if(!mMandatoryFieldsList.contains(field)) {
            mMandatoryFieldsList.add(field);
        }
    }
    protected RequestMandatoryFieldsChecker() {
        addMandatoryFields(RequestFieldsList.EcrNumber);
        addMandatoryFields(RequestFieldsList.OperationCode);
    }
    public boolean checkMandatoryFields(List<RequestFieldsList> fields) {
        return fields.containsAll(mMandatoryFieldsList);
    }
    public static RequestMandatoryFieldsChecker getChecker(OperationsList operation) {
        switch (operation)
        {
            case Sale:
                return new Sale();
            case MOTO:
                return new MOTO();
            case QuickPayment:
                return new QuickPayment();
            case PreAuth:
                return new PreAuth();
            case SalesCompletion:
                return new SalesCompletion();
            case FastTrack:
                return new FastTrack();
            case Void:
                return new VoidSale();
            case VoidPartialSale:
                return new VoidPartialSale();
            case VoidPreAuth:
                return new VoidPreAuth();
            case Refund:
                return new Refund();
            case RefundWithoutRRN:
                return new RefundWithoutRRN();
        }
        return new RequestMandatoryFieldsChecker();
    }
}
