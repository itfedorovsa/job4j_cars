package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.repository.ModelRepository;

import java.util.List;
import java.util.Optional;

/**
 * Model service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleModelService implements ModelService {

    private final ModelRepository store;

    /**
     * Find all Model by Brand id
     *
     * @param brandId Brand id
     * @return List of Model
     */
    @Override
    public List<Model> findAllModelsByBrandId(int brandId) {
        return store.getAllModelsByBrandId(brandId);
    }

    /**
     * Find Model by id
     *
     * @param modelId Model id
     * @return Optional of Model or empty Optional
     */
    @Override
    public Optional<Model> findModelById(int modelId) {
        return store.getModelById(modelId);
    }

}
