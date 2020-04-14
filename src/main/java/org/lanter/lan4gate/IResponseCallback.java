package org.lanter.lan4gate;


/**
 * Интерфейс для реализации callback, позволяющего получать уведомления об ответах от терминала
 */
public interface IResponseCallback {
    /**
     * В данный метод поступают новые сведения об ответе от терминала
     *
     * @param response Объект, реализующий интерфейс {@link IResponse}
     *                 и содержащий сведения об ответе терминала
     */
    void newResponseMessage(IResponse response);
}
