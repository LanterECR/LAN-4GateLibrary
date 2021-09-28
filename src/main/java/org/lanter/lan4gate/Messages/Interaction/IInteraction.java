package org.lanter.lan4gate.Messages.Interaction;

/**
 * This interface uses for creating command for LAN-4Tap
 */
public interface IInteraction {
    /**
     * Return used code from {@link InteractionList}
     * @return code from {@link InteractionList}
     */
    InteractionList getCode();

    /**
     * Sets code for interaction from {@link InteractionList}
     * @param code one of {@link InteractionList}
     */
    void setCode(InteractionList code);
}
