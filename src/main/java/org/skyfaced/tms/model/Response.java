package org.skyfaced.tms.model;

import org.skyfaced.tms.utils.enums.MessageType;
import org.springframework.lang.Nullable;

public class Response<T> {
    @Nullable
    private final Message message;
    @Nullable
    private final T data;

    public Response(@Nullable Message message, @Nullable T data) {
        this.message = message;
        this.data = data;
    }

    @Nullable
    public Message getMessage() {
        return message;
    }

    @Nullable
    public T getData() {
        return data;
    }

    static public class Success<T> extends Response<T> {
        public Success(@Nullable String message, @Nullable T data) {
            super(message == null ? null : new Message(MessageType.Success, message, null), data);
        }
    }

    static public class Error<T> extends Response<T> {
        public Error(@Nullable String message, @Nullable T data, @Nullable String stackTrace) {
            super(message == null ? null : new Message(MessageType.Error, message, stackTrace), data);
        }
    }

    static public class Warning<T> extends Response<T> {
        public Warning(@Nullable String message, @Nullable T data) {
            super(message == null ? null : new Message(MessageType.Warning, message, null), data);
        }
    }
}
