package org.lanter.lan4gate;

public interface ICommunicationCallback {

    void communicationStarted();

    void communicationStopped();

    void connected();

    void disconnected();
}
