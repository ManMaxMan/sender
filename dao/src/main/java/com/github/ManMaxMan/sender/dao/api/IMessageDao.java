package com.github.ManMaxMan.sender.dao.api;

import com.github.ManMaxMan.sender.dao.entity.MessageEntity;

import java.util.Optional;

public interface IMessageDao {

    void save (MessageEntity messageEntity);
    Optional<MessageEntity> get(long id);

}
