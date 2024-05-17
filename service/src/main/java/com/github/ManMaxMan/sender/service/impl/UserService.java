package com.github.ManMaxMan.sender.service.impl;

import com.github.ManMaxMan.sender.core.api.dto.UserDTO;
import com.github.ManMaxMan.sender.dao.api.IUserDao;
import com.github.ManMaxMan.sender.dao.entity.UserEntity;
import com.github.ManMaxMan.sender.service.api.IMessageService;
import com.github.ManMaxMan.sender.service.api.IUserService;

import java.time.LocalDateTime;

public class UserService implements IUserService {

    private final IUserDao userDao;
    private final IMessageService messageService;

    public UserService(IUserDao userDao, IMessageService messageService) {
        this.userDao = userDao;
        this.messageService = messageService;
    }

    @Override
    public void create(UserDTO userDTO) {

        if (userDao.get(userDTO.getLogin()).isPresent()) {
            throw new IllegalArgumentException("You are already registered in!");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userDTO.getLogin());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setBirthday(userDTO.getBirthday());
        userEntity.setFio(userDTO.getFio());
        userEntity.setDateRegistration(LocalDateTime.now());

        userDao.create(userEntity);

        messageService.create(userDTO.getLogin());

    }
}
