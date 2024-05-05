package com.github.ManMaxMan.sender.service.api;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;

public interface IMessageService {
    void create (MessageDTO messageDTO);
    MessageDTO get (Long id);
}
