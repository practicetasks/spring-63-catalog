package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.User;

import java.util.Optional;

public interface UserService {
    void create(User user);

    Optional<User> getUser();
}
