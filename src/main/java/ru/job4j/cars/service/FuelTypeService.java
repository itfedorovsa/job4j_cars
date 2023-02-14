package ru.job4j.cars.service;

import ru.job4j.cars.model.FuelType;

import java.util.List;

/**
 * FuelType service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface FuelTypeService {

    List<FuelType> findAllFuelTypes();

    FuelType findFuelTypeById(int fuelTypeId);

}
