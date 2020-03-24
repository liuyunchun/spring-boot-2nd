package com.yunchun.service;

import com.yunchun.domain.User;

public interface UserService {
    User insert(User user);

    User update(User user);

    User find(String id);

    void delete(String id);
}
