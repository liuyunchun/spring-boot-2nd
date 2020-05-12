package com.yunchun.service;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenericService<T, R extends JpaRepository<T, String>> {
    T insert(T t);

    T update(T t);

    void delete(T t);

    List<T> findAll();
}
