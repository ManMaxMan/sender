package com.github.ManMaxMan.sender.dao.impl;

import com.github.ManMaxMan.sender.dao.api.IMessageDao;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.dao.factory.DaoFactory;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.Optional;

public class MessageDao implements IMessageDao {
    @Override
    public void save(MessageEntity messageEntity) {

        messageEntity.setDateCreate(LocalDateTime.now());

        EntityManager em = DaoFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(messageEntity);
        em.getTransaction().commit();
    }

    @Override
    public Optional<MessageEntity> get(long id) {
        EntityManager em = DaoFactory.getEntityManager();

        MessageEntity messageEntity = em.find(MessageEntity.class, id);

        return Optional.ofNullable(messageEntity);
    }
}
