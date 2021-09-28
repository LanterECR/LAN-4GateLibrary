package org.lanter.lan4gate.MessageProcessor.Builder;

import org.lanter.lan4gate.Messages.Interaction.IInteraction;
import org.lanter.lan4gate.Messages.Notification.INotification;
import org.lanter.lan4gate.Messages.Request.IRequest;

/**
 * The interface for building messages
 */
public interface IMessageBuilder {
    /**
     * Assemble message from {@link IRequest} to byte array
     *
     * @param request Filled object {@link IRequest}
     * @return byte array, contains message. On error - array is empty
     */
    byte[] buildMessage(IRequest request);

    /**
     * Assemble message from {@link INotification} to byte array
     *
     * @param notification Filled object {@link INotification}
     * @return byte array, contains message. On error array is empty
     */
    byte[] buildMessage(INotification notification);

    /**
     * Assemble message from {@link IInteraction} to byte array
     * @param interaction Filled object {@link IInteraction}
     * @return byte array, contains message. On error array is empty
     */
    byte[] buildMessage(IInteraction interaction);
}
