package org.lanter.lan4gate.MessageProcessor.Parser;

import org.lanter.lan4gate.Implementation.MessageProcessor.Parser.JSONParser;

public class MessageParserFactory {
    public static IMessageParser getParser() {
        return new JSONParser();
    }
}
