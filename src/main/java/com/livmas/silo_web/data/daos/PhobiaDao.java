package com.livmas.silo_web.data.daos;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import com.livmas.silo_web.data.entities.PhobiaEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PhobiaDao extends PropertyDao {
    @Override
    public PhobiaEntity readItem(UUID id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        PhobiaEntity value = session.get(PhobiaEntity.class, id);
        tx1.commit();
        session.close();

        return value;
    }
}
