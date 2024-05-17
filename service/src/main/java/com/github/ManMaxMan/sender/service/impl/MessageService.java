package com.github.ManMaxMan.sender.service.impl;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;
import com.github.ManMaxMan.sender.dao.api.IMessageDao;
import com.github.ManMaxMan.sender.dao.entity.EMessageStatus;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.service.api.IConverter;
import com.github.ManMaxMan.sender.service.api.IMessageService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MessageService implements IMessageService {

    private final IMessageDao messageDao;
    private final IConverter<MessageEntity,MessageDTO> entityToDTO;
    //private final ISendingService sendingService;

    public MessageService (IMessageDao messageDao,
                           IConverter<MessageEntity,MessageDTO> entityToDTO){
        this.messageDao = messageDao;
        this.entityToDTO = entityToDTO;
        //this.sendingService = sendingService;
    }

    @Transactional
    @Override
    public void create(MessageDTO messageDTO) {

        if(messageDTO.getRecipient()==null){
            throw new IllegalArgumentException("Recipient cannot be null");
        }

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setDateCreate(LocalDateTime.now());
        messageEntity.setRecipient(messageDTO.getRecipient());
        messageEntity.setSubject(messageDTO.getSubject());
        messageEntity.setBody(messageDTO.getBody());
        messageEntity.setStatus(EMessageStatus.LOADED);
        messageDao.save(messageEntity);

    }

    @Transactional
    @Override
    public MessageDTO get(Long id) {
        Optional<MessageEntity> optional = messageDao.get(id);
        return optional.map(entityToDTO::convert).orElse(null);
    }

    @Transactional
    @Override
    public void create(List<MessageDTO> messageDTOList) {
        messageDTOList.forEach(this::create);
    }

    @Transactional
    @Override
    public void update(MessageEntity messageEntity) {
        messageDao.update(messageEntity);
    }

    @Transactional
    @Override
    public List<MessageDTO> get(Integer page, Integer size) {

        List<MessageEntity> messageEntities = messageDao.get(page, size);

        return messageEntities.stream().map(entityToDTO::convert).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<MessageEntity> getLoaded() {
        return messageDao.get(EMessageStatus.LOADED);
    }

    @Override
    public void create(String loginOfNewUser) {

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setDateCreate(LocalDateTime.now());
        messageEntity.setRecipient(loginOfNewUser);
        messageEntity.setSubject("Successful registration");
        messageEntity.setBody("Hi, "+ loginOfNewUser+"! You registered success. Thank you!");
        messageEntity.setStatus(EMessageStatus.LOADED);
        messageDao.save(messageEntity);
    }
}
