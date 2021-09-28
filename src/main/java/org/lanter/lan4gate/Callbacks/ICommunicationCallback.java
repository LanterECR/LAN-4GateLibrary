package org.lanter.lan4gate.Callbacks;

import org.lanter.lan4gate.ILan4Gate;

/**
 * The interface provides callback to receive connection status notification.
 */
public interface ICommunicationCallback {

    /**
     * This callback will be called, when communication monitoring was successful started.
     *
     * @param initiator Reference to {@link ILan4Gate} example, that has called this callback
     */
    void communicationStarted(ILan4Gate initiator);

    /**
     * This callback will be called, when communication monitoring was successful stopped.
     *
     * @param initiator Reference to {@link ILan4Gate} example, that has called this callback
     */
    void communicationStopped(ILan4Gate initiator);

    /**
     * This callback will be called, when {@link org.lanter.lan4gate.Communication.ICommunication} successfull connected
     * @param initiator Reference to {@link ILan4Gate} example, that has called this callback
     */
    void connected(ILan4Gate initiator);

    /**
     * This callback will be called, when {@link org.lanter.lan4gate.Communication.ICommunication} connection lost
     * @param initiator Reference to {@link ILan4Gate} example, that has called this callback
     */
    void disconnected(ILan4Gate initiator);
}
