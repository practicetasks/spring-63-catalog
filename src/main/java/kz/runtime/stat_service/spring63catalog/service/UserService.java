package kz.runtime.stat_service.spring63catalog.service;

import kz.runtime.stat_service.spring63catalog.model.User;

public interface UserService {
    void create(User user);

    User getUser();
}
