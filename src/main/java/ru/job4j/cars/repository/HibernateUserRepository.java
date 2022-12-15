package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate repository class
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 23.11.22
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateUserRepository implements UserRepository {
    private final CrudRepository crudRepository;

    /**
     * Save user in DB
     *
     * @param user User
     * @return User with id
     */
    public User create(User user) {
        crudRepository.run(session -> session.persist(user));
        return user;
    }

    /**
     * Update user in DB
     *
     * @param user User
     */
    public void update(User user) {
        crudRepository.run(session -> session.merge(user));
    }

    /**
     * Delete user by id
     *
     * @param userId ID
     */
    public void delete(int userId) {
        crudRepository.run(
                "DELETE FROM User WHERE id = :uId",
                Map.of("uId", userId)
        );
    }

    /**
     * List of users sorted by id
     *
     * @return List of users
     */
    public List<User> findAllOrderById() {
        return crudRepository.query("FROM User ORDER BY id ASC", User.class);
    }

    /**
     * Find user by id
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
     * List of users by login LIKE %key%
     *
     * @param key Key
     * @return List of users
     */
    public List<User> findByLikeLogin(String key) {
        return crudRepository.query(
                "FROM User WHERE login LIKE :uKey", User.class,
                Map.of("uKey", "%" + key + "%")
        );
    }

    /**
     * Find user by login
     *
     * @param login Login
     * @return Optional of user or empty Optional
     */
    public Optional<User> findByLogin(String login) {
        return crudRepository.optional(
                "FROM User WHERE login = :uLogin", User.class,
                Map.of("uLogin", login)
        );
    }
}