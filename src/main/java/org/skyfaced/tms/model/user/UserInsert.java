package org.skyfaced.tms.model.user;

import org.skyfaced.tms.model.ReceiveValidator;
import org.skyfaced.tms.utils.consts.ApplicationConstants;
import org.skyfaced.tms.utils.exceptions.ErrorException;
import org.springframework.lang.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInsert extends UserUpsert implements ReceiveValidator {
    private final String password;

    public UserInsert(String username, String password, @Nullable String name, @Nullable String email, short roleId) {
        super(username, name, email, roleId);
        this.password = password;
    }

    public void validate() throws ErrorException {
        if (username == null) throw new ErrorException("Имя пользователя не может быть пустым");

        int usernameLength = username.length();
        if (usernameLength < ApplicationConstants.MIN_USERNAME_LENGTH) throw new ErrorException(
                String.format("Минимальное длина имени пользователя %d", ApplicationConstants.MIN_USERNAME_LENGTH)
        );
        if (usernameLength > ApplicationConstants.MAX_USERNAME_LENGTH) throw new ErrorException(
                String.format("Максимальная длина имени пользователя %d", ApplicationConstants.MAX_USERNAME_LENGTH)
        );

        Pattern usernamePattern = Pattern.compile("\\p{Alnum}+");
        Matcher usernameMatcher = usernamePattern.matcher(username);
        if (!usernameMatcher.matches()) throw new ErrorException(
                "Неверный паттерн имени пользователя, доступные символы [a-z][A-Z][0-9]"
        );

        if (password == null) throw new ErrorException("Пароль не может быть пустым");

        int passwordLength = password.length();
        if (passwordLength < ApplicationConstants.MIN_PASSWORD_LENGTH) throw new ErrorException(
                String.format("Минимальное длина пароля %d", ApplicationConstants.MIN_PASSWORD_LENGTH)
        );
        if (passwordLength > ApplicationConstants.MAX_PASSWORD_LENGTH) throw new ErrorException(
                String.format("Максимальная длина пароля %d", ApplicationConstants.MAX_PASSWORD_LENGTH)
        );

        Pattern passwordPattern = Pattern.compile("\\p{Graph}+");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches()) throw new ErrorException(
                "Неверный паттерн пароля, доступные символы [a-z][A-Z][0-9]!\\\"#\\$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~"
        );
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
