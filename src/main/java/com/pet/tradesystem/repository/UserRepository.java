package com.pet.tradesystem.repository;

import com.pet.tradesystem.domain.User;

public interface UserRepository extends AppRepository<User, Integer> {

    User findUserByLogin(String login);

    boolean isExist(User user);
}
