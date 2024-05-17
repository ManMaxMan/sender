package com.github.ManMaxMan.sender.dao.impl;

import com.github.ManMaxMan.sender.dao.api.IUserDao;
import com.github.ManMaxMan.sender.dao.entity.UserEntity;
import com.github.ManMaxMan.sender.dao.factory.DaoFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Optional;

public class UserDao implements IUserDao {
    @Override
    public UserEntity create(UserEntity entity) {

        EntityManager em = DaoFactory.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
        query.from(UserEntity.class);

        em.persist(entity);

        return entity;
    }

    @Override
    public Optional<UserEntity> get(String login) {

        EntityManager em = DaoFactory.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> query = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = query.from(UserEntity.class);
        query.select(root).where(cb.equal(root.get("login"), login));
        Optional<UserEntity> entity = Optional.ofNullable(em.createQuery(query).getSingleResult());
        return entity;

    }
}
