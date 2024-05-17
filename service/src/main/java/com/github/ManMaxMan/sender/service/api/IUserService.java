package com.github.ManMaxMan.sender.service.api;

import com.github.ManMaxMan.sender.core.api.dto.UserDTO;
import com.github.ManMaxMan.sender.dao.entity.UserEntity;

public interface IUserService {
    void create (UserDTO userDTO);
}
