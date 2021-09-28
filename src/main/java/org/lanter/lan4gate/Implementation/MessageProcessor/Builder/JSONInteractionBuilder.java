package org.lanter.lan4gate.Implementation.MessageProcessor.Builder;

import org.json.JSONException;
import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.RootFields;
import org.lanter.lan4gate.Messages.Interaction.IInteraction;
import org.lanter.lan4gate.Messages.Interaction.InteractionFieldsList;

public class JSONInteractionBuilder {
    public static boolean createObject(JSONObject root, IInteraction interaction) throws JSONException {
        JSONObject object = new JSONObject();
        addObjectFields(object, interaction);

        boolean result = object.length() > 0;
        if(result) {
            root.put(RootFields.OBJECT, object);
        }
        return result;
    }
    private static void addObjectFields(JSONObject object, IInteraction interaction) throws JSONException {
        if(interaction != null) {
            object.put(InteractionFieldsList.Code.getString(), interaction.getCode());
        }
    }
}
