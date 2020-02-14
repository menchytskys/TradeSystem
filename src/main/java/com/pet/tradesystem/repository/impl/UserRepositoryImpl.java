package com.pet.tradesystem.repository.impl;

import com.pet.tradesystem.domain.User;
import com.pet.tradesystem.repository.UserRepository;
import com.pet.tradesystem.repository.rowMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;
    private UserMapper userMapper;

    private static final String SQL_SELECT_ALL = "SELECT id, login, password, isAdmin FROM users";
    private static final String SQL_SELECT_BY_ID = "SELECT id, login, password, isAdmin FROM users WHERE id = ?";
    private static final String SQL_SELECT_BY_LOGIN = "SELECT id, login, password, isAdmin FROM users WHERE login = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM users WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO users (id, login, password, isAdmin) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE users SET login = ?, password = ?, isAdmin=?  WHERE id= ?";
    private static final String SQL_IS_USER_EXIST = "SELECT count(*) FROM users WHERE login = ?";

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = new UserMapper();
    }

    public boolean add(User entity) {
        return jdbcTemplate.update(SQL_INSERT, entity.getId(), entity.getLogin(), entity.getPassword(), entity.getIsAdmin()) > 0;
    }

    public User findById(Integer primaryKey) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userMapper, primaryKey);
    }

    public boolean isExist(User user) {
        boolean exists = false;
        int count = jdbcTemplate.queryForObject(SQL_IS_USER_EXIST, new Object[]{user.getLogin()}, Integer.class);
        exists = count > 0;

        return exists;
    }

    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userMapper);
    }

    public boolean update(User entity) {
        return jdbcTemplate.update(SQL_UPDATE, entity.getLogin(), entity.getPassword(), entity.getId()) > 0;
    }

    public boolean delete(Integer primaryKey) {
        return jdbcTemplate.update(SQL_DELETE_BY_ID, primaryKey) > 0;
    }

    public User findUserByLogin(String login) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_LOGIN, userMapper, login);
    }
}
