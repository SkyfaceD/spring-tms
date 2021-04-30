package org.skyfaced.springdemo.model;

import org.skyfaced.springdemo.utils.enums.MessageType;
import org.springframework.lang.Nullable;

public class Message {
    private final MessageType type;
    private final String text;
    @Nullable
    private final String stackTrace;

    public Message(MessageType type, String text, @Nullable String stackTrace) {
        this.type = type;
        this.text = text;
        this.stackTrace = stackTrace;
    }

    public MessageType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    @Nullable
    public String getStackTrace() {
        return stackTrace;
    }
}
