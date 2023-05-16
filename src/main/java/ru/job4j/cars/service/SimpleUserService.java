package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * User service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleUserService implements UserService {

    private final UserRepository store;

    /**
     * Save User in DB
     *
     * @param user User
     * @return Optional of User
     */
    @Override
    public Optional<User> add(User user) {
        return store.add(user);
    }

    /**
     * Update User in DB
     *
     * @param user User
     */
    @Override
    public void update(User user) {
        store.update(user);
    }

    /**
     * Delete User by id
     *
     * @param userId User id
     */
    @Override
    public void delete(int userId) {
        store.delete(userId);
    }

    /**
     * Find list of User sorted by id
     *
     * @return List of User
     */
    @Override
    public List<User> findAllUsersOrderById() {
        return store.findAllUsersOrderById();
    }

    /**
     * Find User by id
     *
     * @return User
     */
    @Override
    public Optional<User> findUserById(int userId) {
        return store.findUserById(userId);
    }

    /**
     * List of User by login LIKE %key%
     *
     * @param key Key
     * @return List of User
     */
    @Override
    public List<User> findUserByLikeLogin(String key) {
        return store.findUserByLikeLogin(key);
    }

    /**
     * Find User by login
     *
     * @param login Login
     * @return Optional of User or empty Optional
     */
    @Override
    public Optional<User> findUserByLogin(String login) {
        return store.findUserByLogin(login);
    }

    /**
     * Find User by login and password
     *
     * @param login    Login
     * @param password Password
     * @return Optional of User or empty Optional
     */
    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        return store.findUserByLoginAndPassword(login, password);
    }

}
