package org.skyfaced.springdemo.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.skyfaced.springdemo.model.role.RoleEntity;
import org.springframework.lang.Nullable;

public class User {
    private final String id;
    private final String username;
    @Nullable
    private final String name;
    @Nullable
    private final String email;
    private final boolean isActive;
    private final RoleEntity roleEntity;

    public User(String id, String username, @Nullable String name, @Nullable String email, boolean isActive, RoleEntity roleEntity) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.isActive = isActive;
        this.roleEntity = roleEntity;
    }

    public String getId() {
        return id;
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

    @JsonProperty("isActive")
    public boolean isActive() {
        return isActive;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }
}
