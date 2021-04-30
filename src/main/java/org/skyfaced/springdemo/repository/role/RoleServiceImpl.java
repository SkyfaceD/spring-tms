package org.skyfaced.springdemo.repository.role;

import org.skyfaced.springdemo.model.role.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository repository;

    @Override
    public Optional<RoleEntity> findById(short id) {
        return repository.findById(id);
    }
}
