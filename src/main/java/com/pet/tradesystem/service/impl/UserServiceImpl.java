package com.pet.tradesystem.service.impl;

import com.pet.tradesystem.domain.User;
import com.pet.tradesystem.repository.UserRepository;
import com.pet.tradesystem.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements AppService<User, Integer> {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean add(User entity) {
        if (userRepository.isExist(entity)) {
            return false;
        } else {
            return userRepository.add(entity);
        }
    }

    public User findById(Integer primaryKey) {
        return userRepository.findById(primaryKey);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void update(User entity) {
        userRepository.update(entity);
    }

    public void delete(Integer primaryKey) {
        userRepository.delete(primaryKey);
    }

    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public boolean isExist(User user) {
        return userRepository.isExist(user);
    }
}
