package org.lanter.lan4gate.MessageProcessor.Builder;

import org.lanter.lan4gate.Implementation.MessageProcessor.Builder.JSONMessageBuilder;

public class MessageBuilderFactory {
    public static IMessageBuilder getBuilder(){
        return new JSONMessageBuilder();
    }
}
