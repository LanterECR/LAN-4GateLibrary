package org.lanter.lan4gate;

public interface ICommunicationCallback {

    void communicationStarted(Lan4Gate initiator);

    void communicationStopped(Lan4Gate initiator);

    void connected(Lan4Gate initiator);

    void disconnected(Lan4Gate initiator);
}
