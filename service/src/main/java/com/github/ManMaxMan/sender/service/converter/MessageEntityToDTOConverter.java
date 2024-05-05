package com.github.ManMaxMan.sender.service.converter;

import com.github.ManMaxMan.sender.core.api.dto.MessageDTO;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.service.api.IConverter;

public class MessageEntityToDTOConverter implements IConverter<MessageEntity, MessageDTO> {
    @Override
    public MessageDTO convert(MessageEntity item) {
        return MessageDTO.builder()
                .recipient(item.getRecipient())
                .subject(item.getSubject())
                .body(item.getBody())
                .build();
    }
}
