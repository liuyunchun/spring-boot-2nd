package com.yunchun.repository.impl;

import com.yunchun.domain.User;
import com.yunchun.mapper.UserMapper;
import com.yunchun.repository.UserDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("com.yunchun.repository.impl.UserDaoImpl")
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;
    //connection依賴注入

    @Override
    public User insert(User user) {
        jdbcTemplate.update("INSERT INTO USER(ID_,PASSWORD_,NAME_,EMAIL_) VALUES(?,?,?,?)",
                user.getId(), user.getPassword(), user.getName(),user.getEmail());
        return user;
    }

    @Override
    public User update(User user) {
        jdbcTemplate.update("UPDATE USER " +
                "SET PASSWORD_=?,NAME_=?,EMAIL_=? " +
                "WHERE ID_=? ", user.getPassword(), user.getName(),user.getEmail(),user.getId());
        return user;
    }

    @Override
    public User find(String id) {
        User user;
        try {
            user = (User) jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID_=?", new Object[]{id}, new UserMapper());

        } catch (EmptyResultDataAccessException e) {
            //JDBC查無資料會噴錯，要另外處理
            user = null;
        }
        return user;
    }

    @Override
    public void delete(String id) {
        jdbcTemplate.update("DELETE FROM USER WHERE ID_=?", id);
    }
}
