package org.skyfaced.tms.model.user;

import org.skyfaced.tms.model.role.RoleEntity;

public class UserMapper {
    public static User toUser(UserEntity entity) {
        return new User(
                entity.getId().toString(),
                entity.getUsername(),
                entity.getName(),
                entity.getEmail(),
                entity.isActive(),
                entity.getRole()
        );
    }

    public static UserEntity toEntity(UserInsert user, RoleEntity roleEntity) {
        return new UserEntity(
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                roleEntity
        );
    }
}
