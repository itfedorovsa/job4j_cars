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

    @Override
    public Optional<User> add(User user) {
        return store.add(user);
    }

    @Override
    public void update(User user) {
        store.update(user);
    }

    @Override
    public void delete(int userId) {
        store.delete(userId);
    }

    @Override
    public List<User> findAllUsersOrderById() {
        return store.findAllUsersOrderById();
    }

    @Override
    public Optional<User> findUserById(int userId) {
        return store.findUserById(userId);
    }

    @Override
    public List<User> findUserByLikeLogin(String key) {
        return store.findUserByLikeLogin(key);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return store.findUserByLogin(login);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        return store.findUserByLoginAndPassword(login, password);
    }
}
