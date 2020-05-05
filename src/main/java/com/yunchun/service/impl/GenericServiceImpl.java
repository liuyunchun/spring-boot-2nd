package com.yunchun.service.impl;

import com.yunchun.service.GenericService;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericServiceImpl <T, R extends JpaRepository> implements GenericService<T>{
    @Setter
    private R r;

    @Override
    public T insert(T t) {
        return (T) r.save(t);
    }

    @Override
    public T update(T t) {
        return (T) r.save(t);
    }

    public abstract T find(String id);

    @Override
    public void delete(T t) {
        r.delete(t);
    }
}
