package org.skyfaced.springdemo.route.api.v1;

import org.skyfaced.springdemo.model.Response;
import org.skyfaced.springdemo.model.user.User;
import org.skyfaced.springdemo.model.user.UserInsert;
import org.skyfaced.springdemo.model.user.UserUpdate;
import org.skyfaced.springdemo.repository.user.UserService;
import org.skyfaced.springdemo.utils.ApplicationUtils;
import org.skyfaced.springdemo.utils.UUIDUtils;
import org.skyfaced.springdemo.utils.consts.ApplicationConstants;
import org.skyfaced.springdemo.utils.exceptions.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ApplicationConstants.ROUTE_API_V1)
public class UserController {
    private static final String singularRoute = "/user";
    private static final String pluralRoute = "/users";

    @Autowired
    UserService service;

    @PutMapping(singularRoute)
    @ResponseStatus(value = HttpStatus.CREATED, code = HttpStatus.CREATED)
    public Response<User> putUser(@RequestBody UserInsert user) throws ErrorException {
        ApplicationUtils.validate(user);
        return ApplicationUtils.success("Пользователь успешно добавлен", service.save(user));
    }

    @GetMapping(singularRoute + "/{id}")
    public Response<User> getUser(@PathVariable String id) throws ErrorException {
        UUID userId = UUIDUtils.toUUID(id);
        return ApplicationUtils.success(null, service.findById(userId));
    }

    @PatchMapping(singularRoute)
    public Response<User> patchUser(@RequestBody UserUpdate user) throws Exception {
        ApplicationUtils.validate(user);
        return ApplicationUtils.success("Пользователь успешно обновлен", service.update(user));
    }

    @DeleteMapping(singularRoute)
    public Response<Nullable> deleteUser(@RequestParam String id) {
        UUID userId = UUIDUtils.toUUID(id);
        service.deleteById(userId);
        return ApplicationUtils.success("Пользователь успешно удален", null);
    }

    @PatchMapping(singularRoute + "/lock")
    public Response<User> lock(@RequestParam String id) {
        UUID userId = UUIDUtils.toUUID(id);
        return ApplicationUtils.success(
                "Пользователь успешно заблокирован",
                service.lockById(userId)
        );
    }

    @PatchMapping(singularRoute + "/unlock")
    public Response<User> unlock(@RequestParam String id) {
        UUID userId = UUIDUtils.toUUID(id);
        return ApplicationUtils.success(
                "Пользователь успешно разблокирован",
                service.unlockById(userId)
        );
    }

    @PatchMapping(pluralRoute)
    public Response<List<User>> putUsers(@RequestBody List<UserInsert> users) throws ErrorException {
        ApplicationUtils.validate(users);
        return ApplicationUtils.success("Пользователи успешно добавлены", service.saveAll(users));
    }

    @GetMapping(pluralRoute)
    public Response<List<User>> getUsers() {
        return ApplicationUtils.success(null, service.findAll());
    }
}
