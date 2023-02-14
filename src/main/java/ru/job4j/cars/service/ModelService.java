package ru.job4j.cars.service;

import ru.job4j.cars.model.Model;

import java.util.List;

/**
 * Model service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface ModelService {

    List<Model> findAllModelsByBrandId(int brandId);

    Model findModelById(int modelId);

}