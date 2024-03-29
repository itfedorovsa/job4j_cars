package ru.job4j.cars.service;

import ru.job4j.cars.model.User;

import java.util.List;
import java.util.Optional;

/**
 * User service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.01.23
 */
public interface UserService {

    Optional<User> add(User user);

    void update(User user);

    void delete(int userId);

    List<User> findAllUsersOrderById();

    Optional<User> findUserById(int userId);

    List<User> findUserByLikeLogin(String key);

    Optional<User> findUserByLogin(String login);

    Optional<User> findUserByLoginAndPassword(String login, String password);

}
