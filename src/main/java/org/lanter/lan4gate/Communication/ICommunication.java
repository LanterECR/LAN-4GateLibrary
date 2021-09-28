package org.lanter.lan4gate.Communication;

import java.io.IOException;

/**
 * The interface for implements communications
 */
public interface ICommunication {
    /**
     * Open communication. It may be connect, file open, etc.
     * @throws IOException if communication cannot be opened
     */
    void openCommunication() throws IOException;

    /**
     * Close communication
     * @throws IOException if communication cannot be closed
     */
    void closeCommunication() throws IOException;

    /**
     * Return open state of current communication
     *
     * @return true, if communication is opened
     */
    boolean isOpen();

    /**
     * Initiate connecting for current connection
     * @throws IOException if the connection cannot be connect due to an error
     */
    void connect() throws IOException;

    /**
     * Disconnect current connection
     * @throws IOException if the connection cannot be disconnect due to an error
     */
    void disconnect() throws IOException;

    /**
     * Return connection state of current communication
     *
     * @return the boolean
     */
    boolean isConnected();

    /**
     * Send data over connection
     *
     * @param data data for send
     * @throws IOException if cannot send data due to an error
     */
    void sendData(byte[] data) throws IOException;

    /**
     * Gets data.
     *
     * @return the data
     */
    byte[] getData() throws IOException;

    /**
     * Do one iteration of communication loop.
     */
    void doCommunication() throws IOException;
}