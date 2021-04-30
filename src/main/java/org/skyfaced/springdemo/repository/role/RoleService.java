package org.skyfaced.springdemo.repository.role;

import org.skyfaced.springdemo.model.role.RoleEntity;

import java.util.Optional;

public interface RoleService {
    Optional<RoleEntity> findById(short id);
}
