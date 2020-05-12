package com.yunchun.service.impl;

import com.yunchun.service.GenericService;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericServiceImpl<T, R extends JpaRepository<T, String>> implements GenericService<T, R> {
    @Setter
    R repository;


    @Override
    public T insert(T t) {
        return repository.save(t);
    }

    @Override
    public T update(T t) {
        return repository.save(t);
    }

    public abstract T find(String id);

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
