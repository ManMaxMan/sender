package com.github.ManMaxMan.sender.controller.http;


import com.github.ManMaxMan.sender.core.api.dto.UserDTO;
import com.github.ManMaxMan.sender.service.api.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //в более глобалных проектах наверное поставил бы OK
    public void create(@RequestBody UserDTO userDTO) {

        userService.create(userDTO);
    }
}
