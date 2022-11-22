package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.job4j.cars.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *  User repository class
 */
@AllArgsConstructor
public class UserRepository {
    private final SessionFactory sf;

    /**
     * Save user in DB
     * @param user User
     * @return User with id
     */
    public User create(User user) {
        Session session = sf.openSession();
        User rslUser = new User();
        try {
            session.beginTransaction();
            Query<User> query = session.createQuery("INSERT INTO User (login, password) VALUES (:log, :pass)");
                            query.setParameter("log", user.getLogin());
                            query.setParameter("pass", user.getPassword());
                            query.executeUpdate();
            rslUser = query.uniqueResult();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return rslUser;
    }

    /**
     * Update user in DB
     * @param user User
     */
    public void update(User user) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("UPDATE User SET password = :pass WHERE login = :uLogin")
                    .setParameter("pass", user.getPassword())
                    .setParameter("uLogin", user.getLogin())
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /**
     * Delete user by id
     * @param userId ID
     */
    public void delete(int userId) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE User WHERE id = :uId")
                    .setParameter("uId", userId)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    /**
     * List of users sorted by id
     * @return List of users
     */
    public List<User> findAllOrderById() {
        Session session = sf.openSession();
        List<User> users = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User");
            query.executeUpdate();
            users = query.stream().sorted().toList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return users;
    }

    /**
     * Find user by id
     * @return User
     */
    public Optional<User> findById(int userId) {
        Session session = sf.openSession();
        Optional<User> user = Optional.empty();
        try {
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User WHERE id = :uId");
                    query.setParameter("uId", userId);
            user = query.uniqueResultOptional();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return user;
    }

    /**
     * List of users by login LIKE %key%
     * @param key Key
     * @return List of users
     */
    public List<User> findByLikeLogin(String key) {
        Session session = sf.openSession();
        List<User> users = new ArrayList<>();
        try {
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User WHERE login LIKE :key");
                    query.setParameter("key", key);
                    query.executeUpdate();
            users = new ArrayList<>(query.list());
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return users;
    }

    /**
     * Find user by login
     * @param login Login
     * @return Optional of user or empty Optional
     */
    public Optional<User> findByLogin(String login) {
        Session session = sf.openSession();
        Optional<User> user = Optional.empty();
        try {
            session.beginTransaction();
            Query<User> query =  session.createQuery("FROM User WHERE login = :log");
                    query.setParameter("log", login);
                    user = query.uniqueResultOptional();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        return user;
    }
}