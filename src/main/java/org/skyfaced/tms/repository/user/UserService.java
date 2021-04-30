package org.skyfaced.tms.repository.user;

import org.skyfaced.tms.model.user.User;
import org.skyfaced.tms.model.user.UserInsert;
import org.skyfaced.tms.model.user.UserUpdate;
import org.skyfaced.tms.utils.exceptions.ErrorException;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User save(UserInsert user);

    User findById(UUID id) throws ErrorException;

    User update(UserUpdate user) throws Exception;

    void deleteById(UUID id);

    User lockById(UUID id);

    User unlockById(UUID id);

    List<User> saveAll(List<UserInsert> users);

    List<User> findAll();
}
