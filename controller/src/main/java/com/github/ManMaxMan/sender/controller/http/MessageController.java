package com.github.ManMaxMan.sender.controller.http;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ManMaxMan.sender.controller.factory.AppFactory;
import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;
import com.github.ManMaxMan.sender.service.api.IMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private final ObjectMapper mapper = AppFactory.getMapper();
    private final IMessageService messageService;

    public MessageController(IMessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(produces = "application/json;charset=UTF-8")
    public String get(@RequestParam(value = "id", required = false) Long id)
            throws IOException {

        if(id != null){
            return mapper.writeValueAsString(messageService.get(id));
        } else {
            return null;
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void sendMessage(@RequestBody MessageDTO message) {
        this.messageService.create(message);
    }
}
