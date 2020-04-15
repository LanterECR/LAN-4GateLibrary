package org.lanter.lan4gate;

public interface IErrorCallback {
    void errorMessage(String error, Lan4Gate initiator);
    void errorException(Exception exception, Lan4Gate initiator);
}
