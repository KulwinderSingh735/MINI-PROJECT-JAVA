package com.example.sms.config;

import com.example.sms.dao.StudentDAO;
import com.example.sms.dao.StudentDAOImpl;
import com.example.sms.service.FeeService;
import com.example.sms.service.StudentService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration as SpringConfig;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringConfig
@ComponentScan(basePackages = "com.example.sms")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public StudentDAO studentDAO(SessionFactory sessionFactory) {
        return new StudentDAOImpl(sessionFactory);
    }

    @Bean
    public FeeService feeService(StudentDAO studentDAO) {
        return new FeeService(studentDAO);
    }

    @Bean
    public StudentService studentService(StudentDAO studentDAO, FeeService feeService) {
        return new StudentService(studentDAO, feeService);
    }
}
