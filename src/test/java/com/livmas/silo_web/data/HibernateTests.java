package com.livmas.silo_web.data;

import com.livmas.silo_web.data.entities.ProfessionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

class HibernateTests {
    @Test
    void mainHibernateTest() {
        ProfessionEntity profession = new ProfessionEntity();
        profession.setName("Учитель биологии");

        //Get Session
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(profession);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Profession ID="+ profession.getId());

//        ProfessionEntity profession1 = session.get(SessionFactory.class, profession.getId());

        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }

}