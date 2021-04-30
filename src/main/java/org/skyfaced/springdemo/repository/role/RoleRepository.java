package org.skyfaced.springdemo.repository.role;

import org.skyfaced.springdemo.model.role.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Short> {
}
