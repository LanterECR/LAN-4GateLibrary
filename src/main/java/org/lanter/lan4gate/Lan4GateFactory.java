package org.lanter.lan4gate;

import org.lanter.lan4gate.Communication.CommunicationFactory;
import org.lanter.lan4gate.Communication.ICommunication;
import org.lanter.lan4gate.Implementation.Lan4Gate;

/**
 * Factory for create {@link ILan4Gate}
 */
public class Lan4GateFactory {
    /**
     * Create {@link ILan4Gate} with ecr number and {@link ICommunication}
     * @param ecrNumber logical ecr number
     * @param communication using communication
     * @return null, if ILan4Gate not create
     */
    public static ILan4Gate getLan4Gate(int ecrNumber, ICommunication communication) {
        ILan4Gate gate = new Lan4Gate();
        gate.setEcrNumber(ecrNumber);
        gate.setCommunication(communication);
        return gate;
    }

    /**
     * Same as {@link Lan4GateFactory#getLan4Gate(int, ICommunication)} but call {@link CommunicationFactory#getSingleTCPServer()} by default
     * @param ecrNumber logical ecr number
     * @return null, if ILan4Gate not create
     */
    public static ILan4Gate getLan4Gate(int ecrNumber) {
        return getLan4Gate(ecrNumber, CommunicationFactory.getSingleTCPServer());
    }

    /**
     * Same as {@link Lan4GateFactory#getLan4Gate(int)} but ecrNumber is 1 by default
     * @return null, if ILan4Gate not create
     */
    public static ILan4Gate getLan4Gate() {
        int defaultEcrNumber = 1;
        return getLan4Gate(defaultEcrNumber);
    }
}
