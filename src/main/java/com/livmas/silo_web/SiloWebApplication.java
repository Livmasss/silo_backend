package com.livmas.silo_web;

import com.livmas.silo_web.data.HibernateSessionFactoryUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SiloWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiloWebApplication.class, args);
        HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession().close();
    }
}
