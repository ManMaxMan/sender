package com.github.ManMaxMan.sender.dao.api;

import com.github.ManMaxMan.sender.dao.entity.UserEntity;

import java.util.Optional;

public interface IUserDao {
    UserEntity create(UserEntity entity);
    Optional<UserEntity> get(String login);
}
