package com.livmas.silo_web.data.daos;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import com.livmas.silo_web.data.entities.CatastropheEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CatastropheDao implements BaseDao<CatastropheEntity> {
    @Override
    public void createItem(CatastropheEntity item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(item);
        tx1.commit();
        session.close();
    }

    @Override
    public CatastropheEntity readItem(UUID id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        CatastropheEntity value = session.get(CatastropheEntity.class, id);
        tx1.commit();
        session.close();

        return value;
    }

    @Override
    public void updateItem(CatastropheEntity item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(item);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteItem(CatastropheEntity item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(item);
        tx1.commit();
        session.close();
    }
}
