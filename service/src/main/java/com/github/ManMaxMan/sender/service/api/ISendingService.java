package com.github.ManMaxMan.sender.service.api;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;

import javax.mail.MessagingException;

public interface ISendingService {
    void sendMessage(MessageDTO messageDTO) throws MessagingException;
}
