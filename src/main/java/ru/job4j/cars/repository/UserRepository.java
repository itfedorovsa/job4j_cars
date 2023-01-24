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

    Optional<User> add(User user);

    void update(User user);

    void delete(int userId);

    List<User> findAllUsersOrderById();

    Optional<User> findUserById(int userId);

    List<User> findUserByLikeLogin(String key);

    Optional<User> findUserByLogin(String login);

    Optional<User> findUserByLoginAndPassword(String login, String password);

}


