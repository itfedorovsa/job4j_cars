package ru.job4j.cars.repository;

import ru.job4j.cars.model.FuelType;

import java.util.List;

/**
 * FuelType repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface FuelTypeRepository {

    List<FuelType> findAllFuelTypes();

    FuelType findFuelTypeById(int fuelTypeId);

}
