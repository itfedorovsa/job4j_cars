package ru.job4j.cars.repository;

import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

/**
 * User repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 23.11.22
 */
public interface UserRepository {

    /**
     * Save User in DB
     *
     * @param user User
     * @return Optional of User
     */
    Optional<User> add(User user);

    /**
     * Update User in DB
     *
     * @param user User
     */
    void update(User user);

    /**
     * Delete User by id
     *
     * @param userId User id
     */
    void delete(int userId);

    /**
     * Find list of User sorted by id
     *
     * @return List of User
     */
    List<User> findAllUsersOrderById();

    /**
     * Find User by id
     *
     * @return User
     */
    Optional<User> findUserById(int userId);

    /**
     * List of User by login LIKE %key%
     *
     * @param key Key
     * @return List of User
     */
    List<User> findUserByLikeLogin(String key);

    /**
     * Find User by login
     *
     * @param login Login
     * @return Optional of User or empty Optional
     */
    Optional<User> findUserByLogin(String login);

    /**
     * Find User by login and password
     *
     * @param login    Login
     * @param password Password
     * @return Optional of User or empty Optional
     */
    Optional<User> findUserByLoginAndPassword(String login, String password);

}


