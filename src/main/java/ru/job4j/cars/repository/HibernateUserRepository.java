package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate User repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 23.11.22
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateUserRepository implements UserRepository {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "FROM User WHERE login = :uLogin AND password = :uPass";

    private final CrudRepository crudRepository;

    /**
     * Save User in DB
     *
     * @param user User
     * @return Optional of User
     */
    public Optional<User> add(User user) {
        Optional<User> temp = Optional.empty();
        try {
            crudRepository.run(session -> session.save(user));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return user.getId() == 0 ? temp : Optional.of(user);
    }

    /**
     * Update User in DB
     *
     * @param user User
     */
    public void update(User user) {
        crudRepository.run(session -> session.merge(user));
    }

    /**
     * Delete User by id
     *
     * @param userId User id
     */
    public void delete(int userId) {
        crudRepository.run(
                "DELETE FROM User WHERE id = :uId",
                Map.of("uId", userId)
        );
    }

    /**
     * Find list of User sorted by id
     *
     * @return List of User
     */
    public List<User> findAllOrderById() {
        return crudRepository.query("FROM User ORDER BY id ASC", User.class);
    }

    /**
     * Find User by id
     *
     * @return User
     */
    public Optional<User> findById(int userId) {
        return crudRepository.optional(
                "FROM User WHERE id = :uId", User.class,
                Map.of("uId", userId)
        );
    }

    /**
     * List of User by login LIKE %key%
     *
     * @param key Key
     * @return List of User
     */
    public List<User> findByLikeLogin(String key) {
        return crudRepository.query(
                "FROM User WHERE login LIKE :uKey", User.class,
                Map.of("uKey", "%" + key + "%")
        );
    }

    /**
     * Find User by login
     *
     * @param login Login
     * @return Optional of User or empty Optional
     */
    public Optional<User> findByLogin(String login) {
        return crudRepository.optional(
                "FROM User WHERE login = :uLogin", User.class,
                Map.of("uLogin", login)
        );
    }

    /**
     * Find User by login and password
     *
     * @param login    Login
     * @param password Password
     * @return Optional of User or empty Optional
     */
    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        Optional<User> user = Optional.empty();
        try {
            user = crudRepository.optional(
                    FIND_BY_LOGIN_AND_PASSWORD,
                    User.class,
                    Map.of("uLogin", login, "uPass", password));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return user;
    }
}