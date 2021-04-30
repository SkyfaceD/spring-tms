package org.skyfaced.tms.repository.user;

import org.skyfaced.tms.model.user.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    List<UserEntity> findAllByOrderByCreatedAtAsc();
}
