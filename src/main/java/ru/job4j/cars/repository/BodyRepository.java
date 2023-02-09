package ru.job4j.cars.repository;

import ru.job4j.cars.model.Body;

import java.util.List;

/**
 * Body repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface BodyRepository {

    List<Body> findAllBodies();

    Body findBodyById(int bodyId);

}
