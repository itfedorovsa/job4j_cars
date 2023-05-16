package ru.job4j.cars.repository;

import ru.job4j.cars.model.Model;

import java.util.List;
import java.util.Optional;

/**
 * Model repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface ModelRepository {

    /**
     * Find all Model by Brand id
     *
     * @param brandId Brand id
     * @return List of Model
     */
    List<Model> getAllModelsByBrandId(int brandId);

    /**
     * Find Model by id
     *
     * @param modelId Model id
     * @return Optional of Model or empty Optional
     */
    Optional<Model> getModelById(int modelId);

}
