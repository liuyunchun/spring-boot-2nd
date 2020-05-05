package com.yunchun.service;

public interface GenericService <T>{
    T insert (T t);

    T update (T t);

    void delete (T t);
}
