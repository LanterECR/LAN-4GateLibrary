package org.lanter.lan4gate;

/**
 * This interface provide access for error events.
 * CURRENTLY IS STUB
 */
public interface IErrorCallback {
    /**
     * This callback will be called when a known error has occurred.
     * Using only for display
     *
     * @param error     The error message text
     * @param initiator Reference to {@link Lan4Gate} example, that has called this callback
     */
    void errorMessage(String error, Lan4Gate initiator);

    /**
     * This callback will be called when an unknown error has occurred and exception was throws.
     * Such as no Internet permission for Android applications
     *
     * @param exception The thrown exception
     * @param initiator Reference to {@link Lan4Gate} example, that has called this callback
     */
    void errorException(Exception exception, Lan4Gate initiator);
}
