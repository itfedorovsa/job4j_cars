package ru.job4j.cars.repository;

import ru.job4j.cars.model.FuelType;

import java.util.List;
import java.util.Optional;

/**
 * FuelType repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface FuelTypeRepository {

    List<FuelType> findAllFuelTypes();

    Optional<FuelType> findFuelTypeById(int fuelTypeId);

}
