package com.github.ManMaxMan.sender.service.job.impl;

import com.github.ManMaxMan.sender.dao.entity.EMessageStatus;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.service.api.IMessageService;
import com.github.ManMaxMan.sender.service.api.ISendingService;
import com.github.ManMaxMan.sender.service.api.exceptions.FailMessageSendException;
import com.github.ManMaxMan.sender.service.job.api.IJob;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageSendJob implements IJob {

    private final ISendingService sendingService;
    private final IMessageService messageService;

    public MessageSendJob(ISendingService sendingService, IMessageService messageService) {
        this.sendingService = sendingService;
        this.messageService = messageService;
    }

    @Override
    public void start() {

        List<MessageEntity> entityList = messageService.getLoaded();
        for (MessageEntity message : entityList) {
            try{
                sendingService.send(message);
                message.setStatus(EMessageStatus.OK);
            } catch (FailMessageSendException e) {
                message.setStatus(EMessageStatus.ERROR);
            } finally {
                this.messageService.update(message);
            }
        }

    }
}
