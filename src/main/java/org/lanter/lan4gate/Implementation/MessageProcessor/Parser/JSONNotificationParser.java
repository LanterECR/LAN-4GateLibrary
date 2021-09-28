package org.lanter.lan4gate.Implementation.MessageProcessor.Parser;

import org.json.JSONObject;
import org.lanter.lan4gate.Implementation.MessageProcessor.Fields.NotificationFields;
import org.lanter.lan4gate.Implementation.Messages.Notification.Notification;
import org.lanter.lan4gate.Messages.Notification.INotification;
import org.lanter.lan4gate.Messages.Notification.NotificationsList;

public class JSONNotificationParser {
    public static INotification parseNotification(JSONObject objectField) {
        INotification result = null;
        if(objectField != null) {
            result = new Notification();
            NotificationsList notificationType = NotificationsList.getValue(objectField.optInt(NotificationFields.Code.getString(),0));
            if(notificationType != null) {
                result.setNotificationCode(notificationType);
                result.setMessage(objectField.optString(NotificationFields.Message.getString()));
                result.setAdditionalInfo(objectField.optString(NotificationFields.Additional.getString()));
            }
        }
        return result;
    }
}
