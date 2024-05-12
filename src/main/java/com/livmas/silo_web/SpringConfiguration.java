package com.livmas.silo_web;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories("com.livmas.silo_web.data.repositories")
public class SpringConfiguration {
    @Bean(name="entityManagerFactory")
    public SessionFactory sessionFactory() {
        return HibernateSessionFactoryUtil.getSessionFactory();
    }
    @Bean(name = "transactionManager")
    public PlatformTransactionManager dbTransactionManager() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                sessionFactory()
        );
        return transactionManager;
    }
}
