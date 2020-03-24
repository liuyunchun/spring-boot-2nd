package com.yunchun.repository;

import com.yunchun.domain.User;

public interface UserDao {
    User insert(User user);

    User update(User user);

    User find(String id);

    void delete(String id);
}
