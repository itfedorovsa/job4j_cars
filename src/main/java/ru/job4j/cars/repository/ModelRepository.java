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

    List<Model> getAllModelsByBrandId(int brandId);

    Optional<Model> getModelById(int modelId);

}
