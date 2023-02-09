package ru.job4j.cars.service;

import ru.job4j.cars.model.Body;

import java.util.List;

/**
 * Body service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface BodyService {

    List<Body> findAllBodies();

    Body findBodyById(int bodyId);

}
