package org.lanter.lan4gate.Callbacks;

import org.lanter.lan4gate.ILan4Gate;
import org.lanter.lan4gate.Messages.Response.IResponse;

/**
 * This interface provides callback for receive response from terminal.
 */
public interface IResponseCallback {

    /**
     * This callback will be called, when terminal sends a new correct response.
     *
     * @param response {@link IResponse} implementation example, contains all response info
     * @param initiator Reference to {@link ILan4Gate} example, that has called this callback
     */
    void newResponseMessage(IResponse response, ILan4Gate initiator);
}
