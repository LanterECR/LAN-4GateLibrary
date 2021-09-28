package org.lanter.lan4gate.Communication;

import org.lanter.lan4gate.Implementation.Communication.SingleConnectionTCPServer;
import org.lanter.lan4gate.Implementation.Communication.SizeControlDecorator;

public class CommunicationFactory {
    public static ICommunication getSingleTCPServer(int port) {
        SingleConnectionTCPServer server = new SingleConnectionTCPServer();
        server.setPort(port);
        return server;
    }
    public static ICommunication getSingleTCPServer() {
        int defaultPort = 20501;
        return getSingleTCPServer(defaultPort);
    }

    public static ICommunication getSizeControlProxy(ICommunication mainCommunication) {
        SizeControlDecorator decorator = null;
        if(mainCommunication != null) {
            decorator = new SizeControlDecorator(mainCommunication);
        }
        return decorator;
    }
}
