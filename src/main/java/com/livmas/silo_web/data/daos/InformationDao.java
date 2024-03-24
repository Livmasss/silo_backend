package com.livmas.silo_web.data.daos;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import com.livmas.silo_web.data.entities.InformationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformationDao extends PropertyDao {
    @Override
    public InformationEntity readItem(UUID id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        InformationEntity value = session.get(InformationEntity.class, id);
        tx1.commit();
        session.close();

        return value;
    }
}
