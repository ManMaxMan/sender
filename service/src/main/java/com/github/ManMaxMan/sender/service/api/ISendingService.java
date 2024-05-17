package com.github.ManMaxMan.sender.service.api;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.service.api.exceptions.FailMessageSendException;

import javax.mail.MessagingException;

public interface ISendingService {
    void send(MessageEntity messageEntity) throws FailMessageSendException;
}
