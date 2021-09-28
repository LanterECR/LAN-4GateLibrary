package org.lanter.lan4gate.Implementation.MessageProcessor.Builder;

import org.json.JSONException;
import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.ClassFieldValuesList;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.RootFields;
import org.lanter.lan4gate.MessageProcessor.Builder.IMessageBuilder;
import org.lanter.lan4gate.Messages.Interaction.IInteraction;
import org.lanter.lan4gate.Messages.Notification.INotification;
import org.lanter.lan4gate.Messages.Request.IRequest;

import java.nio.charset.StandardCharsets;

public class JSONMessageBuilder implements IMessageBuilder {

    @Override
    public byte[] buildMessage(IRequest request) {
        byte[] result = null;
        try {
            if (request != null && request.checkMandatoryFields()) {
                JSONObject root = new JSONObject();
                if (createClassField(root, ClassFieldValuesList.Request) && createObjectField(root, request)) {
                    result = convertToByteArray(root.toString());
                }
            }
        } catch (JSONException ignored) {
            //TODO add reaction
        }
        return result;
    }

    @Override
    public byte[] buildMessage(INotification notification) {
        byte[] result = null;
        try {
            if (notification != null && notification.getNotificationCode() != null) {
                JSONObject root = new JSONObject();
                if (createClassField(root, ClassFieldValuesList.Notification) && createObjectField(root, notification)) {
                    result = convertToByteArray(root.toString());
                }
            }
        } catch (JSONException ignored) {}
        return result;
    }

    @Override
    public byte[] buildMessage(IInteraction interaction) {
        byte[] result = null;
        try {
            if (interaction != null && interaction.getCode() != null) {
                JSONObject root = new JSONObject();
                if (createClassField(root, ClassFieldValuesList.Interaction) && createObjectField(root, interaction)) {
                    result = convertToByteArray(root.toString());
                }
            }
        } catch (JSONException ignored) {}
        return result;
    }

    private boolean createClassField(JSONObject root, final ClassFieldValuesList type) throws JSONException {
        root.put(RootFields.CLASS, type.getString());

        return root.length() > 0;
    }

    private boolean createObjectField(JSONObject root, IRequest request) throws JSONException {
        return JSONRequestBuilder.createObject(root, request);
    }


    private boolean createObjectField(JSONObject root, INotification notification) throws JSONException {
        return JSONNotificationBuilder.createObject(root, notification);
    }

    private boolean createObjectField(JSONObject root, IInteraction interaction) throws JSONException {
        return JSONInteractionBuilder.createObject(root, interaction);
    }

    private byte[] convertToByteArray(String message) {
        return message.getBytes(StandardCharsets.UTF_8);
    }
}
