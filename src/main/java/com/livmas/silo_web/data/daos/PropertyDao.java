package com.livmas.silo_web.data.daos;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import com.livmas.silo_web.data.entities.HealthEntity;
import com.livmas.silo_web.data.entities.PropertyEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.UUID;

public abstract class PropertyDao implements BaseDao<PropertyEntity> {

    @Override
    public void createItem(PropertyEntity item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(item);
        tx1.commit();
        session.close();
    }

    @Override
    public abstract PropertyEntity readItem(UUID id);

    @Override
    public void updateItem(PropertyEntity item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(item);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteItem(PropertyEntity item) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(item);
        tx1.commit();
        session.close();
    }
}
