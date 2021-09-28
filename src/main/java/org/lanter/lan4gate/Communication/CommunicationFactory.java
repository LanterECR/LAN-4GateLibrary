package org.lanter.lan4gate.Communication;

import org.lanter.lan4gate.Implementation.Communication.SingleConnectionTCPServer;
import org.lanter.lan4gate.Implementation.Communication.SizeControlDecorator;

/**
 * Factory for create communications
 */
public class CommunicationFactory {
    /**
     * Create TCP server for only one connection on port
     * @param port port in [1; 65535]
     * @return null, if TCP Server not be create
     */
    public static ICommunication getSingleTCPServer(int port) {
        SingleConnectionTCPServer server = new SingleConnectionTCPServer();
        server.setPort(port);
        return server;
    }

    /**
     * Create TCP server for only one connection on default port 20501
     * @return null, if TCP Server not be create
     */
    public static ICommunication getSingleTCPServer() {
        int defaultPort = 20501;
        return getSingleTCPServer(defaultPort);
    }

    /**
     * Create decorator communication. Decorator provides size control for messages
     * In head of message add ASCII-HEX value, contains length of next message
     * @param mainCommunication communication for decoration
     * @return null, if decorator cannot be create
     */
    public static ICommunication getSizeControlDecorator(ICommunication mainCommunication) {
        SizeControlDecorator decorator = null;
        if(mainCommunication != null) {
            decorator = new SizeControlDecorator(mainCommunication);
        }
        return decorator;
    }
}
