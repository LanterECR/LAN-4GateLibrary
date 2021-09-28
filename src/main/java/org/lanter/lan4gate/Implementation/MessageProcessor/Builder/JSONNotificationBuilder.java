package org.lanter.lan4gate.Implementation.MessageProcessor.Builder;

import org.json.JSONException;
import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.NotificationFields;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.RootFields;
import org.lanter.lan4gate.Messages.Notification.INotification;

public class JSONNotificationBuilder {
    public static boolean createObject(JSONObject root, INotification notification) throws JSONException {
        JSONObject object = new JSONObject();
        addObjectFields(object, notification);

        boolean result = object.length() > 0;
        if (result) {
            root.put(RootFields.OBJECT, object);
        }
        return result;
    }
    private static void addObjectFields(JSONObject object, INotification notification) throws JSONException {
        if(notification != null) {
            if(notification.getNotificationCode() != null) {
                object.put(NotificationFields.Code.getString(), notification.getNotificationCode().getNumber());
            }

            if(notification.getMessage() != null && !notification.getMessage().isEmpty()) {
                object.put(NotificationFields.Message.getString(), notification.getMessage());
            }
            if(notification.getAdditionalInfo() != null && !notification.getAdditionalInfo().isEmpty()) {
                object.put(NotificationFields.Additional.getString(), notification.getAdditionalInfo());
            }
        }
    }
}