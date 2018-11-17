package com.pokemonentities;

import com.pokemonentities.pokemondatabase.Pokemon;
import com.pokemonentities.pokemondatabase.PokemonsDatabase;
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

public class PokemonEntitiesManager {
    private static Connection conn;

    private static Configuration configuration;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static PokemonEntities pokemonEntities;

    public PokemonEntitiesManager() {
        createDatabase();
        setupDbConnection();
        createTable();
        fillDatabase();
    }

    public static void createDatabase() {
        configuration = new Configuration();
        configuration.configure("hibernate_pokemons.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void setupDbConnection() {
        try {
            String uri = "jdbc:mysql://localhost:3306/pokedex_pokemons?user=root";
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
        pokemonEntities = new PokemonEntities();
    }

    public static void fillDatabase() {
        PokemonsDatabase.initiateDatabase();
        List<Pokemon> pokemons = PokemonsDatabase.getPokemons();

        for (int i = 0; i < pokemons.size(); i++) {
            if (!checkIfPokemonAlreadyExists(pokemons.get(i).getName())) {
                addPokemon(pokemons.get(i).getName(),pokemons.get(i).getCreatedDate());
            }

        }
    }

    public static void addPokemon(String pokemon, String currentDate) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            pokemonEntities.setName(pokemon);
            pokemonEntities.setCreatedDate(currentDate);
            session.save(pokemonEntities);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static boolean checkIfPokemonAlreadyExists(String pokemonName) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean doesUserExist = false;

        try {
            tx = session.beginTransaction();
            List pokemons = session.createQuery("FROM PokemonEntities").list();

            for (int i = 0; i < pokemons.size(); i++) {
                PokemonEntities pokemonEntities = (PokemonEntities) pokemons.get(i);
                if (pokemonName.equalsIgnoreCase(pokemonEntities.getName())) {
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

    public static ArrayList<Pokemon> getPokemonsListFromDB() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean doesUserExist = false;

        ArrayList<Pokemon> pokemns = new ArrayList<>();

        try {
            tx = session.beginTransaction();
            List pokemons = session.createQuery("FROM PokemonEntities").list();

            for (int i = 0; i < pokemons.size(); i++) {
                PokemonEntities pokemonEntities = (PokemonEntities) pokemons.get(i);
                pokemns.add(new Pokemon(pokemonEntities.getName(), pokemonEntities.getLocation(), pokemonEntities.getCreatedDate()));
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pokemns;
    }

    public static String getCreatedDate() {

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
        String newFormat = currentDateTime.format(format);

        return newFormat;
    }

}
