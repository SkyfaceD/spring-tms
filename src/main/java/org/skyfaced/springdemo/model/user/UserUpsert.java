package org.skyfaced.springdemo.model.user;

import org.springframework.lang.Nullable;

public class UserUpsert {
    protected final String username;
    @Nullable
    protected final String name;
    @Nullable
    protected final String email;
    protected final short roleId;

    public UserUpsert(String username, @Nullable String name, @Nullable String email, short roleId) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.roleId = roleId;
    }
}
