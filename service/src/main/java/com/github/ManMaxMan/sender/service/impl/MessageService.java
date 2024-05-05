package com.github.ManMaxMan.sender.service.impl;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;
import com.github.ManMaxMan.sender.dao.api.IMessageDao;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.service.api.IConverter;
import com.github.ManMaxMan.sender.service.api.IMessageService;
import com.github.ManMaxMan.sender.service.api.ISendingService;

import javax.mail.MessagingException;
import java.util.Optional;

public class MessageService implements IMessageService {

    private final IMessageDao messageDao;
    private final IConverter<MessageEntity,MessageDTO> entityToDTO;
    private final ISendingService sendingService;

    public MessageService (IMessageDao messageDao,
                           IConverter<MessageEntity,MessageDTO> entityToDTO, ISendingService sendingService){
        this.messageDao = messageDao;
        this.entityToDTO = entityToDTO;
        this.sendingService = sendingService;
    }


    @Override
    public void create(MessageDTO messageDTO) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setRecipient(messageDTO.getRecipient());
        messageEntity.setSubject(messageDTO.getSubject());
        messageEntity.setBody(messageDTO.getBody());
        messageDao.save(messageEntity);

        try {
            sendingService.sendMessage(messageDTO);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MessageDTO get(Long id) {
        Optional<MessageEntity> optional = messageDao.get(id);
        return optional.map(entityToDTO::convert).orElse(null);
    }
}
