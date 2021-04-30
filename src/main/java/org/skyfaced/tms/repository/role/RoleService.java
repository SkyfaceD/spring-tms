package org.skyfaced.tms.repository.role;

import org.skyfaced.tms.model.role.RoleEntity;

import java.util.Optional;

public interface RoleService {
    Optional<RoleEntity> findById(short id);
}
