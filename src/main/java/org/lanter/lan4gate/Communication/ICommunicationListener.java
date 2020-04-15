package org.lanter.lan4gate.Communication;

public interface ICommunicationListener {

    void newData(String data);

    void communicationStarted();

    void communicationStopped();

    void connected();

    void disconnected();

    void errorMessage(String error);

    void errorException(Exception exception);
}
