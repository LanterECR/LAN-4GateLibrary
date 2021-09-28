package org.lanter.lan4gate.Implementation.MessageProcessor.Parser;

import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.ClassFieldValuesList;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.RootFields;
import org.lanter.lan4gate.MessageProcessor.Parser.IMessageParser;
import org.lanter.lan4gate.MessageProcessor.Parser.MessageType;
import org.lanter.lan4gate.Messages.Notification.INotification;
import org.lanter.lan4gate.Messages.Request.IRequest;
import org.lanter.lan4gate.Messages.Response.IResponse;

import java.util.ArrayDeque;
import java.util.Queue;

public class JSONParser implements IMessageParser {
    private final Queue<IRequest> mRequest = new ArrayDeque<>();
    private final Queue<IResponse> mResponse = new ArrayDeque<>();
    private final Queue<INotification> mNotification = new ArrayDeque<>();

    @Override
    public IResponse getResponse() {
        return mResponse.poll();
    }

    @Override
    public int getResponseCount() {
        return mResponse.size();
    }

    @Override
    public INotification getNotification() { return mNotification.poll(); }

    @Override
    public int getNotificationCount() {
        return mResponse.size();
    }

    @Override
    public MessageType parse(String json) {
        MessageType result = MessageType.NoMessage;
        if(json != null && !json.isEmpty()) {
            try {
                JSONObject root = new JSONObject(json);

                MessageType currentType = getClassField(root);
                if (checkObjectField(root)) {
                    JSONObject objectField = getObjectField(root);

                    switch (currentType) {
                        case Response:
                            IResponse response = JSONResponseParser.parse(objectField);
                            if (response != null && mResponse.offer(response)) {
                                result = currentType;
                            }
                            break;
                        case Notification:
                            INotification notification = JSONNotificationParser.parseNotification(objectField);
                            if (notification != null && mNotification.offer(notification)) {
                                result = currentType;
                            }
                            break;
                    }
                }
            } catch (Exception ignored) {
                //TODO add reaction
            }
        }
        return result;
    }
    private MessageType getClassField(JSONObject root) {
        MessageType result = MessageType.NoMessage;
        if(root != null) {
            String classField = root.optString(RootFields.CLASS);
            if(classField.equals(ClassFieldValuesList.Response.getString())) {
                result = MessageType.Response;
            } else if(classField.equals(ClassFieldValuesList.Notification.getString())) {
                result = MessageType.Notification;
            }
        }
        return result;
    }
    private boolean checkObjectField(JSONObject root) {
        return root != null &&  root.has(RootFields.OBJECT);
    }
    private JSONObject getObjectField(JSONObject root) {
       return root.optJSONObject(RootFields.OBJECT);
    }
}
