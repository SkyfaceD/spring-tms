package org.skyfaced.springdemo.repository.user;

import org.skyfaced.springdemo.model.user.User;
import org.skyfaced.springdemo.model.user.UserInsert;
import org.skyfaced.springdemo.model.user.UserUpdate;
import org.skyfaced.springdemo.utils.exceptions.ErrorException;

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
