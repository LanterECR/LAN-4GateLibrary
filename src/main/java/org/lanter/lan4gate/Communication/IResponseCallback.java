package org.lanter.lan4gate.Communication;

import org.lanter.lan4gate.Messages.Responses.Response;

public interface IResponseCallback {
    void newResponseMessage(Response response);
}
