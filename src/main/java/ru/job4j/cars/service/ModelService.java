package ru.job4j.cars.service;

import ru.job4j.cars.model.Model;

import java.util.List;
import java.util.Optional;

/**
 * Model service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface ModelService {

    /**
     * Find all Model by Brand id
     *
     * @param brandId Brand id
     * @return List of Model
     */
    List<Model> findAllModelsByBrandId(int brandId);

    /**
     * Find Model by id
     *
     * @param modelId Model id
     * @return Optional of Model or empty Optional
     */
    Optional<Model> findModelById(int modelId);

}
