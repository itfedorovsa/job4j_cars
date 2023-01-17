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
    public List<User> findAllOrderById() {
        return store.findAllOrderById();
    }

    @Override
    public Optional<User> findById(int userId) {
        return store.findById(userId);
    }

    @Override
    public List<User> findByLikeLogin(String key) {
        return store.findByLikeLogin(key);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return store.findByLogin(login);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return store.findByLoginAndPassword(login, password);
    }
}
