package com.livmas.silo_web.data;

import com.livmas.silo_web.data.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(HibernateSessionFactoryUtil.class);

    private HibernateSessionFactoryUtil() {}

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            initiateProperties(configuration);
            initiateTables(configuration);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            logger.info("Hibernate Java Config serviceRegistry created");
            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Exception ex) {
            logger.error("Initial SessionFactory creation failed.%s".formatted(ex));
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void initiateProperties(Configuration configuration) throws IOException {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("/hibernate-dev.properties")) {
            props.load(input);
            logger.info("Hibernate properties loaded: {}", props);
        } catch (IOException ex) {
            logger.error("Error loading hibernate-dev.properties", ex);
        }

        configuration.setProperties(props);
    }

    private static void initiateTables(Configuration configuration) {
        //Player properties
        configuration.addAnnotatedClass(ActionEntity.class);
        configuration.addAnnotatedClass(BunkerEntity.class);
        configuration.addAnnotatedClass(CharacterEntity.class);
        configuration.addAnnotatedClass(GenderEntity.class);
        configuration.addAnnotatedClass(HealthEntity.class);
        configuration.addAnnotatedClass(HobbyEntity.class);
        configuration.addAnnotatedClass(InformationEntity.class);
        configuration.addAnnotatedClass(InventoryEntity.class);
        configuration.addAnnotatedClass(PhobiaEntity.class);
        configuration.addAnnotatedClass(ProfessionEntity.class);

        configuration.addAnnotatedClass(CatastropheEntity.class);
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
