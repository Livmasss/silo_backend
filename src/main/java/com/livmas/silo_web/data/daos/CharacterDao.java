package com.livmas.silo_web.data.daos;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import com.livmas.silo_web.data.entities.ActionEntity;
import com.livmas.silo_web.data.entities.CharacterEntity;
import com.livmas.silo_web.data.entities.PropertyEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CharacterDao extends PropertyDao {
    @Override
    public CharacterEntity readItem(UUID id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        CharacterEntity value = session.get(CharacterEntity.class, id);
        tx1.commit();
        session.close();

        return value;
    }
}
