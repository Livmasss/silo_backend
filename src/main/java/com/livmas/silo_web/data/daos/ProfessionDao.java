package com.livmas.silo_web.data.daos;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import com.livmas.silo_web.data.entities.ProfessionEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProfessionDao extends PropertyDao {
    @Override
    public ProfessionEntity readItem(UUID id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        ProfessionEntity value = session.get(ProfessionEntity.class, id);
        tx1.commit();
        session.close();

        return value;
    }
}
