package com.github.ManMaxMan.sender.service.api;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;

import java.util.List;

public interface IMessageService {
    void create (MessageDTO messageDTO);
    void create(List<MessageDTO> messageDTOList);
    void create(String loginOfNewUser);
    void update (MessageEntity messageEntity);
    MessageDTO get (Long id);
    List<MessageDTO> get(Integer page, Integer size);
    List<MessageEntity> getLoaded();

}
