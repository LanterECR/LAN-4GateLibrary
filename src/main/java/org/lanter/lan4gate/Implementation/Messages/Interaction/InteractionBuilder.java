package org.lanter.lan4gate.Implementation.Messages.Interaction;


import org.lanter.lan4gate.Messages.InteractionList;

public class InteractionBuilder {
    private final int mEcrNumber;

    public InteractionBuilder(int ecrNumber) {
        mEcrNumber = ecrNumber;
    }

    public Interaction prepareInteraction(InteractionList operation) throws UnsupportedOperationException {
        Interaction result = new Interaction();
        result.setCode(InteractionList.Abort);

        return result;
    }
}
