package com.accountsentities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AccountManager {

    private static Connection conn;
    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static AccountEntity accountEntity;

    public AccountManager() {
        createDatabase();
        setupDbConnection();
        createTable();
    }

    public static void createDatabase() {
        configuration = new Configuration();
        configuration.configure("hibernate_accounts.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void setupDbConnection() {
        try {
            String uri = "jdbc:mysql://localhost:3306/pokedex_accounts?user=root";
            Properties props = setLoginForDB();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(uri, props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Properties setLoginForDB() {
        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "");
        return props;
    }

    public static void createTable() {
        accountEntity = new AccountEntity();
    }

    public static void addNewUser(String email, String username, String password) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            accountEntity.setEmail(email);
            accountEntity.setUsername(username);
            accountEntity.setPassword(password);
            session.save(accountEntity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void addPokemon(String pokemon) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();


            session.save(accountEntity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static boolean checkIfUserAlreadyExists(String username, String email) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean doesUserExist = false;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM AccountEntity").list();

            for (int i = 0; i < users.size(); i++) {
                AccountEntity employee = (AccountEntity) users.get(i);
                if (username.equalsIgnoreCase(employee.getUsername()) || email.equalsIgnoreCase(employee.getEmail())) {
                    doesUserExist = true;
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return doesUserExist;
    }

    public static boolean checkIfUsernameAlreadyExists(String username) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean doesUserExist = false;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM AccountEntity").list();

            for (int i = 0; i < users.size(); i++) {
                AccountEntity employee = (AccountEntity) users.get(i);
                if (username.equalsIgnoreCase(employee.getUsername())) {
                    doesUserExist = true;
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return doesUserExist;
    }

    public static boolean checkIfPasswordMatches(String password) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean doesPasswordMatch = false;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM AccountEntity").list();

            for (int i = 0; i < users.size(); i++) {
                AccountEntity employee = (AccountEntity) users.get(i);
                if (password.equalsIgnoreCase(employee.getPassword())) {
                    doesPasswordMatch = true;
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return doesPasswordMatch;
    }

    public static Account getLoggedAccount(String username) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Account loggedAccount = null;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM AccountEntity").list();


            for (int i = 0; i < users.size(); i++) {
                accountEntity = (AccountEntity) users.get(i);
                if (accountEntity.getUsername().equalsIgnoreCase(username)) {

                    loggedAccount = new Account(accountEntity.getId(), accountEntity.getEmail(), accountEntity.getUsername(), accountEntity.getPassword(), (ArrayList<String>) accountEntity.getNameCreatedPokemon());
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return loggedAccount;
    }




}
