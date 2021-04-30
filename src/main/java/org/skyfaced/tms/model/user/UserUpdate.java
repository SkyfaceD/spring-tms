package org.skyfaced.tms.model.user;

import org.skyfaced.tms.model.ReceiveValidator;
import org.skyfaced.tms.utils.UUIDUtils;
import org.skyfaced.tms.utils.consts.ApplicationConstants;
import org.skyfaced.tms.utils.exceptions.ErrorException;
import org.springframework.lang.Nullable;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUpdate extends UserUpsert implements ReceiveValidator {
    private final String id;

    public UserUpdate(String id, String username, @Nullable String name, @Nullable String email, short roleId) {
        super(username, name, email, roleId);
        this.id = id;
    }

    @Override
    public void validate() throws ErrorException {
        String message;

        if (id == null) {
            message = "Индентификатор не может быть пустым";
        } else if (!UUIDUtils.isValidUUID(id)) {
            message = "Невалидный идентификатор";
        } else if (username == null) {
            message = "Имя пользователя не может быть пустым";
        } else if (username.length() < ApplicationConstants.MIN_USERNAME_LENGTH) {
            message = String.format("Минимальное длина имени пользователя %d", ApplicationConstants.MIN_USERNAME_LENGTH);
        } else if (username.length() > ApplicationConstants.MAX_USERNAME_LENGTH) {
            message = String.format("Максимальная длина имени пользователя %d", ApplicationConstants.MAX_USERNAME_LENGTH);
        } else {
            Pattern usernamePattern = Pattern.compile("\\p{Alnum}+");
            Matcher usernameMatcher = usernamePattern.matcher(username);
            message = !usernameMatcher.matches()
                    ? "Неверный паттерн пароля, доступные символы [a-z][A-Z][0-9]!\\\"#\\$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~"
                    : null;
        }

        if (message != null) throw new ErrorException(message);
    }

    public UUID getId() {
        return UUIDUtils.toUUID(id);
    }

    public String getUsername() {
        return username;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public short getRoleId() {
        return roleId;
    }
}
