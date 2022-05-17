package com.hisamprakoso.karyawanapp.controller;

import java.io.File;

import org.hibernate.SessionFactory;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
// import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration()
                .configure(new File("C:\\code\\karyawan-app\\src\\main\\resources\\hibernate.cfg.xml"));
        // ServiceRegistry serviceRegistry = new
        // StandardServiceRegistryBuilder().applySettings(
        // configuration.getProperties()).build();
        // SessionFactory sessionFactory =
        // configuration.buildSessionFactory(serviceRegistry);
        return configuration.buildSessionFactory();
        // return sessionFactory;
    }

}
