package com.yunchun.mapper;

import com.yunchun.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getString("ID_"));
        user.setPassword(resultSet.getString("PASSWORD_"));
        user.setName(resultSet.getString("NAME_"));
        user.setEmail(resultSet.getString("EMAIL_"));
        return user;
    }
}
