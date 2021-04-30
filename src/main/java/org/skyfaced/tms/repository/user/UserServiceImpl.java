package org.skyfaced.tms.repository.user;

import org.skyfaced.tms.model.role.RoleEntity;
import org.skyfaced.tms.model.user.*;
import org.skyfaced.tms.utils.exceptions.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public User save(UserInsert user) {
        RoleEntity role = entityManager.find(RoleEntity.class, user.getRoleId());
        UserEntity entity = UserMapper.toEntity(user, role);
        UserEntity result = repository.save(entity);
        return UserMapper.toUser(result);
    }

    @Override
    public User findById(UUID id) throws ErrorException {
        UserEntity entity = repository.findById(id).orElseThrow(() -> new ErrorException("Не удалось найти пользователя"));
        return UserMapper.toUser(entity);
    }

    @Override
    public User update(UserUpdate user) throws Exception {
        RoleEntity role = entityManager.find(RoleEntity.class, user.getRoleId());
        UserEntity entity = entityManager
                .find(UserEntity.class, user.getId())
                .update(user);
        //Manually update role because hibernate sucks or I am stupid
        entity.setRole(role);

        repository.save(entity);
        return UserMapper.toUser(entity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public User lockById(UUID id) {
        UserEntity entity = entityManager.find(UserEntity.class, id);
        entity.setActive(false);
        return UserMapper.toUser(entity);
    }

    @Override
    public User unlockById(UUID id) {
        UserEntity entity = entityManager.find(UserEntity.class, id);
        entity.setActive(true);
        return UserMapper.toUser(entity);
    }

    @Override
    public List<User> saveAll(List<UserInsert> users) {
        List<UserEntity> entities = users.stream().map(user -> {
            RoleEntity role = entityManager.find(RoleEntity.class, user.getRoleId());
            return UserMapper.toEntity(user, role);
        }).collect(Collectors.toList());
        List<UserEntity> result = (List<UserEntity>) repository.saveAll(entities);
        return result.stream().map(UserMapper::toUser).collect(Collectors.toList());
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = repository.findAllByOrderByCreatedAtAsc();
        return entities.stream().map(UserMapper::toUser).collect(Collectors.toList());
    }
}
