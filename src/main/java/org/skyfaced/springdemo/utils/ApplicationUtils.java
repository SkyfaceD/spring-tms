package org.skyfaced.springdemo.utils;

import org.skyfaced.springdemo.model.ReceiveValidator;
import org.skyfaced.springdemo.model.Response;
import org.skyfaced.springdemo.utils.exceptions.ErrorException;
import org.springframework.lang.Nullable;

import java.util.List;

public final class ApplicationUtils {
    public static <T> Response<T> success(
            @Nullable String message,
            @Nullable T data
    ) {
        return new Response.Success<>(message, data);
    }

    public static <T> Response<T> error(
            @Nullable String message,
            @Nullable T data,
            @Nullable String stackTrace
    ) {
        return new Response.Error<>(message, data, stackTrace);
    }

    public static <T> Response<T> warning(
            @Nullable String message,
            @Nullable T data
    ) {
        return new Response.Warning<>(message, data);
    }

    public static <T extends ReceiveValidator> void validate(T model) throws ErrorException {
        model.validate();
    }

    public static <T extends ReceiveValidator> void validate(List<T> models) throws ErrorException {
        for (T model : models) {
            model.validate();
        }
    }
}
