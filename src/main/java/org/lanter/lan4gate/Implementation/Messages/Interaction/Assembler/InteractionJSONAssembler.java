package org.lanter.lan4gate.Implementation.Messages.Interaction.Assembler;

import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.Messages.Fields.ClassFieldValuesList;
import org.lanter.lan4gate.Implementation.Messages.Fields.RootFields;
import org.lanter.lan4gate.Implementation.Messages.Interaction.Interaction;
import org.lanter.lan4gate.Messages.Fields.InteractionFieldsList;

import java.util.Set;

public class InteractionJSONAssembler {
    Interaction mInteraction;
    String mJsonString;
    public boolean assemble(Interaction request) {
        if(request != null && request.checkMandatoryFields()) {
            mInteraction = request;
            JSONObject root = new JSONObject();
            createClassField(root);
            createObjectField(root);
            mJsonString = root.toString();
            return !mJsonString.isEmpty();
        }
        return false;
    }
    public String getJson() {
        return mJsonString;
    }
    private void createClassField(JSONObject root) {
        root.put(RootFields.CLASS, ClassFieldValuesList.Interaction.getString());
    }
    private void createObjectField(JSONObject root) {
        JSONObject object = new JSONObject();
        addObjectFields(object);
        root.put(RootFields.OBJECT, object);
    }
    private void addObjectFields(JSONObject object) {
        if(mInteraction != null) {
            addFields(object, mInteraction.getMandatoryFields());
            addFields(object, mInteraction.getOptionalFields());
        }
    }
    private void addFields(JSONObject object, Set<InteractionFieldsList> fields) {
        if(fields != null && object != null) {
            for (InteractionFieldsList field : fields) {
                switch (field)
                {
                    case Code:
                        object.put(field.getString(), mInteraction.getCode().getNumber());
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
