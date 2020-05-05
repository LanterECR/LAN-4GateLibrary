package org.lanter.lan4gate;

/**
 * This interface provides callback for receive response from terminal.
 */
public interface IResponseCallback {

    /**
     * This callback will be called, when terminal sends new correct response.
     *
     * @param response {@link IResponse} implementation example, contains all info about response
     * @param initiator Reference to {@link Lan4Gate} example, that has called this callback
     */
    void newResponseMessage(IResponse response, Lan4Gate initiator);
}
