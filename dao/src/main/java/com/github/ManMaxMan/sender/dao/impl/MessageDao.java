package com.github.ManMaxMan.sender.dao.impl;

import com.github.ManMaxMan.sender.dao.api.IMessageDao;
import com.github.ManMaxMan.sender.dao.entity.EMessageStatus;
import com.github.ManMaxMan.sender.dao.entity.MessageEntity;
import com.github.ManMaxMan.sender.dao.factory.DaoFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class MessageDao implements IMessageDao {


    @Override
    public MessageEntity save(MessageEntity messageEntity) {

        EntityManager em = DaoFactory.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MessageEntity> query = cb.createQuery(MessageEntity.class);
        query.from(MessageEntity.class);
        em.persist(messageEntity);

        return messageEntity;
    }

    @Override
    public MessageEntity update(MessageEntity messageEntity) {

        EntityManager em = DaoFactory.getEntityManager();
        Optional<MessageEntity> optionalMessage = get (messageEntity.getId());

        if (optionalMessage.isPresent()) {

            MessageEntity updatedMessageEntity = optionalMessage.get();
            updatedMessageEntity.setStatus(messageEntity.getStatus());
            em.merge(updatedMessageEntity);

            return updatedMessageEntity;
        }

        throw new IllegalStateException("Message not found by id " + messageEntity.getId());
    }

    @Override
    public Optional<MessageEntity> get(long id) {
        EntityManager em = DaoFactory.getEntityManager();

        MessageEntity messageEntity = em.find(MessageEntity.class, id);

        return Optional.ofNullable(messageEntity);
    }

    @Override
    public List<MessageEntity> get(Integer page, Integer size) {

        EntityManager em = DaoFactory.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MessageEntity> query = cb.createQuery(MessageEntity.class);
        query.from(MessageEntity.class);

        List<MessageEntity> messageEntityList = em.createQuery(query)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();

        return messageEntityList;
    }

    @Override
    public List<MessageEntity> get(EMessageStatus eMessageStatus) {

        EntityManager em = DaoFactory.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MessageEntity> query = cb.createQuery(MessageEntity.class);
        Root<MessageEntity> root = query.from(MessageEntity.class);
        query.select(root).where(cb.equal(root.get("status"), EMessageStatus.class));

        return em.createQuery(query).getResultList();
    }
}
