package ru.job4j.cars.service;

import ru.job4j.cars.model.Body;

import java.util.List;
import java.util.Optional;

/**
 * Body service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface BodyService {

    /**
     * Find all Body
     *
     * @return List of Body
     */
    List<Body> findAllBodies();

    /**
     * Find Body by id
     *
     * @param bodyId Body id
     * @return Optional of Body or empty Optional
     */
    Optional<Body> findBodyById(int bodyId);

}
