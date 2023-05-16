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

    /**
     * Find all Body
     *
     * @return List of Body
     */
    @Override
    public List<Body> findAllBodies() {
        return store.findAllBodies();
    }

    /**
     * Find Body by id
     *
     * @param bodyId Body id
     * @return Optional of Body or empty Optional
     */
    @Override
    public Optional<Body> findBodyById(int bodyId) {
        return store.findBodyById(bodyId);
    }
}
