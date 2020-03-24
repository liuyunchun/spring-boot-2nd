package com.yunchun.service.impl;

import com.yunchun.domain.User;
import com.yunchun.repository.UserDao;
import com.yunchun.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("com.yunchun.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao dao;

    @Override
    public User insert(User user) {
        System.out.println("新增前動手腳");
        return dao.insert(user);
    }

    @Override
    public User update(User user) {
        System.out.println("修改前動手腳");
        return dao.update(user);
    }

    @Override
    public User find(String id) {
        System.out.println("修改前動手腳");
        return dao.find(id);
    }

    @Override
    public void delete(String id) {
        System.out.println("修改前動手腳");
        dao.delete(id);
    }
}
