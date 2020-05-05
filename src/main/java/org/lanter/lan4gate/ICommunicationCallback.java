package org.lanter.lan4gate;

/**
 * The interface provides callback to receive connection status notification.
 */
public interface ICommunicationCallback {

    /**
     * This callback will be called, when communication monitoring was successful started.
     *
     * @param initiator Reference to {@link Lan4Gate} example, that has called this callback
     */
    void communicationStarted(Lan4Gate initiator);

    /**
     * This callback will be called, when communication monitoring was successful stopped.
     *
     * @param initiator Reference to {@link Lan4Gate} example, that has called this callback
     */
    void communicationStopped(Lan4Gate initiator);

    /**
     * This callback will be called in 2 cases:
     * 1. In TCP client mode, when {@link Lan4Gate} client was connected to remote host;
     * 2. In TCP server mode, when new client was connected to {@link Lan4Gate} host.
     *
     * @param initiator Reference to {@link Lan4Gate} example, that has called this callback
     */
    void connected(Lan4Gate initiator);

    /**
     * This callback will be called in 2 cases:
     * 1. In TCP client mode, when {@link Lan4Gate} client was disconnected from remote host;
     * 2. In TCP server mode, when client was disconnected from {@link Lan4Gate} host.
     * @param initiator Reference to {@link Lan4Gate} example, that has called this callback
     */
    void disconnected(Lan4Gate initiator);
}
