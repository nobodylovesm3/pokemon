package com.loginsession;

import com.accountsentities.AccountManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EntityLoginSessionManager {
    private static Connection conn;

    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static EntityLoginSession entityLoginSession;

    public EntityLoginSessionManager() {
        createDatabase();
        setupDbConnection();
        createTable();
    }

    public static void createDatabase() {
        configuration = new Configuration();
        configuration.configure("hibernate_logged_user.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void setupDbConnection() {
        try {
            String uri = "jdbc:mysql://localhost:3306/pokedex_logged_user?user=root";
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
        entityLoginSession = new EntityLoginSession();
    }

    public static void addFirstUserCredentials() {

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            entityLoginSession.setIsLogged("No");
            entityLoginSession.setLoggedUsername("");
            session.save(entityLoginSession);

           tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void addNewLoggedUserUsername(String isLogged, String loggedUsername) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM EntityLoginSession").list();

            for (int i = 0; i < users.size(); i++) {
                if (i == 0){
                    EntityLoginSession entityLoginSession = (EntityLoginSession) users.get(i);

                    entityLoginSession.setIsLogged(isLogged);
                    entityLoginSession.setLoggedUsername(loggedUsername);
                }
                if (i > 0){
                    session.delete(users.get(i));
                }
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static String getIsLogged() {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        String isLogged = "";

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM EntityLoginSession").list();

            for (int i = 0; i < users.size(); i++){
                EntityLoginSession entityLoginSession = (EntityLoginSession) users.get(i);
                isLogged = entityLoginSession.getIsLogged();
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isLogged;
    }

    public static String deleteLoggedUserAndData() {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        String isLogged = "";

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM EntityLoginSession").list();
            users.remove(0);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isLogged;
    }
    public static String getLoggedUsername() {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        String loggedUsername = "";

        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM EntityLoginSession").list();
            EntityLoginSession entityLoginSession = (EntityLoginSession) users.get(0);
            loggedUsername = entityLoginSession.getIsLogged();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return loggedUsername;
    }

    public static void addNewPokemon(String pokemon) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM EntityLoginSession").list();
            EntityLoginSession entityLoginSession = (EntityLoginSession) users.get(0);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
