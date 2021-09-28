package org.lanter.lan4gate;

import org.lanter.lan4gate.Callbacks.ICommunicationCallback;
import org.lanter.lan4gate.Callbacks.INotificationCallback;
import org.lanter.lan4gate.Callbacks.IResponseCallback;
import org.lanter.lan4gate.Communication.ICommunication;
import org.lanter.lan4gate.Messages.Interaction.IInteraction;
import org.lanter.lan4gate.Messages.Notification.INotification;
import org.lanter.lan4gate.Messages.Notification.NotificationsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Messages.Request.IRequest;

/**
 * This interface encapsulates ECR protocol LAN-4Gate
 */
public interface ILan4Gate {
    /**
     * Sets logical ecr number
     *
     * @param ecrNumber Logical ECR number, used for communication with terminal. Value in range [1,999]
     */
    void setEcrNumber(int ecrNumber);

    /**
     * Return logical ecr number
     *
     * @return  Logical ECR number, used for communication with terminal. Value in range [1,999]
     */
    int getEcrNumber();

    /**
     * Sets new {@link ICommunication} for communication with terminal
     * @param communication object, implements {@link ICommunication}
     * @throws RuntimeException if communication cannot be changed
     */
    void setCommunication(ICommunication communication) throws RuntimeException;

    /**
     * Return current communication
     * @return Current communication or null
     */
    ICommunication getCommunication();

    /**
     * Add listener for {@link IResponseCallback}
     *
     * @param callback Object, implements interface {@link IResponseCallback}
     */
    void addResponseCallback(IResponseCallback callback);

    /**
     * Remove registered {@link IResponseCallback} listener
     *
     * @param callback Registered {@link IResponseCallback} object
     */
    void removeResponseCallback(IResponseCallback callback);

    /**
     * Add listener for {@link ICommunicationCallback}
     *
     * @param callback Object, implements interface {@link ICommunicationCallback}
     */
    void addCommunicationCallback(ICommunicationCallback callback);

    /**
     * Remove registered {@link ICommunicationCallback} listener
     *
     * @param callback Registered {@link ICommunicationCallback} object
     */
    void removeCommunicationCallback(ICommunicationCallback callback);

    /**
     * Add listener for {@link INotificationCallback}
     *
     * @param callback Object, implements interface {@link INotificationCallback}
     */
     void addNotificationCallback(INotificationCallback callback);

    /**
     * Remove registered {@link INotificationCallback} listener
     *
     * @param callback Registered {@link INotificationCallback} object
     */
    void removeNotificationCallback(INotificationCallback callback);

    /**
     * Start protocol communication.
     * After correct start {@link ICommunicationCallback}.communicationStarted() will be called
     */
    void start();

    /**
     * Returns start state of protocol communication
     *
     * @return True, if already and correct started
     */
    boolean isStarted();

    /**
     * Stop protocol communication.
     * After correct start {@link ICommunicationCallback}.communicationStopped() will be called
     */
    void stop();

    /**
     * Return prepared {@link IRequest}. Fields EcrNumber and OperationCode already sets
     * @param operation one of {@link OperationsList}
     * @return null, if request cannot be created
     */
    IRequest getPreparedRequest(OperationsList operation);

    /**
     * Send new request to terminal
     *
     * @param request Prepared object, implements {@link IRequest}
     */
    void sendRequest(IRequest request);

    /**
     * Return prepared {@link INotification}. Field NotificationCode already sets
     * @param notification one of {@link NotificationsList}
     * @return null, if notification cannot be created
     */
    INotification getPreparedNotification(NotificationsList notification);

    /**
     * Send new interaction to tereminal
     * @param interaction Prepared object, implements {@link IInteraction}
     */
    void sendInteraction(IInteraction interaction);
}
