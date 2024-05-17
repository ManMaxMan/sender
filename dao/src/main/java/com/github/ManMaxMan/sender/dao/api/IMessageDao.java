package com.github.ManMaxMan.sender.dao.api;

import com.github.ManMaxMan.sender.dao.entity.EMessageStatus;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;

import java.util.List;
import java.util.Optional;

public interface IMessageDao {

    MessageEntity save (MessageEntity messageEntity);
    MessageEntity update (MessageEntity messageEntity);
    Optional<MessageEntity> get(long id);
    List<MessageEntity> get(Integer page, Integer size);
    List<MessageEntity> get(EMessageStatus eMessageStatus);

}
