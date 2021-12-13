package org.lanter.lan4gate.Communication;

import org.lanter.lan4gate.Implementation.Communication.SingleConnectionTCPServer;
import org.lanter.lan4gate.Implementation.Communication.SizeControlDecorator;
import org.lanter.lan4gate.Implementation.Communication.TCPClient;

/**
 * Factory for create communications
 */
public class CommunicationFactory {
    /**
     * Create TCP server for only one connection on port
     * @param port port in [1; 65535]
     * @return null, if TCP Server not created
     */
    public static ICommunication getSingleTCPServer(int port) {
        SingleConnectionTCPServer server = (SingleConnectionTCPServer) getSingleTCPServer();
        server.setPort(port);
        return server;
    }

    /**
     * Create TCP server for only one connection on default port 20501
     * @return null, if TCP Server not created
     */
    public static ICommunication getSingleTCPServer() {
        return new SingleConnectionTCPServer();
    }

    /**
     * Create TCP client for specific IP and port
     * @param ip IP in range [1.1.1.1, 255.255.255.255]
     * @param port port in [1; 65535]
     * @return null, if TCP client not created
     */
    public static ICommunication getTCPClient(String ip, int port) {
        TCPClient client = (TCPClient)getTCPClient(port);
        client.setIP(ip);
        return client;
    }

    /**
     * Create TCP client for specific port
     * @param port port in [1; 65535]
     * @return null, if TCP client not created
     */
    public static ICommunication getTCPClient(int port) {
        TCPClient client = (TCPClient) getTCPClient();
        client.setPort(port);
        return client;
    }

    /**
     * Create TCP client with default params
     * @return null, if TCP client not created
     */
    public static ICommunication getTCPClient() {
        return new TCPClient();
    }


    /**
     * Create decorator communication. Decorator provides size control for messages
     * In head of message add ASCII-HEX value, contains length of next message
     * @param mainCommunication communication for decoration
     * @return null, if decorator not created
     */
    public static ICommunication getSizeControlDecorator(ICommunication mainCommunication) {
        SizeControlDecorator decorator = null;
        if(mainCommunication != null) {
            decorator = new SizeControlDecorator(mainCommunication);
        }
        return decorator;
    }
}
