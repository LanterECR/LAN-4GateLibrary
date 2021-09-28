package org.lanter.lan4gate.Implementation.Messages.Interaction;

import org.lanter.lan4gate.Messages.Interaction.IInteraction;

import org.lanter.lan4gate.Messages.Interaction.InteractionFieldsList;
import org.lanter.lan4gate.Messages.Interaction.InteractionList;

import java.util.HashSet;
import java.util.Set;

public class Interaction implements IInteraction {
    private InteractionList mCode;

    public Interaction(){
        addMandatoryFields(InteractionFieldsList.Code);
    }
    private final Set<InteractionFieldsList> mFields = new HashSet<>();

    private final Set<InteractionFieldsList> mMandatoryFieldsList = new HashSet<>();
    private final Set<InteractionFieldsList> mOptionalFieldsList = new HashSet<>();
    protected final void addMandatoryFields(InteractionFieldsList field) {
        mMandatoryFieldsList.add(field);
    }
    protected final void addOptionalFields(InteractionFieldsList field) {
        mOptionalFieldsList.add(field);
    }
    public Set<InteractionFieldsList> getMandatoryFields() {
        return mMandatoryFieldsList;
    }

    public Set<InteractionFieldsList> getOptionalFields() {
        return mOptionalFieldsList;
    }

    public boolean checkMandatoryFields() {
        return mFields.containsAll(mMandatoryFieldsList);
    }

    @Override
    public InteractionList getCode() {
        return mCode;
    }

    @Override
    public void setCode(InteractionList code) {
        mCode = code;
        mFields.add(InteractionFieldsList.Code);
    }

    public Set<InteractionFieldsList> getCurrentFields() {
        return mFields;
    }
}
