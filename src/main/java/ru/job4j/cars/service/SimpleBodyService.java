package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Body;
import ru.job4j.cars.repository.BodyRepository;

import java.util.List;
import java.util.Optional;

/**
 * Body service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleBodyService implements BodyService {

    private final BodyRepository store;

    @Override
    public List<Body> getAllBodies() {
        return store.getAllBodies();
    }

    @Override
    public Optional<Body> getBodyById(int id) {
        return store.getBodyById(id);
    }
}
