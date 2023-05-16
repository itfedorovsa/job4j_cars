package ru.job4j.cars.service;

import ru.job4j.cars.model.Car;

import java.util.List;
import java.util.Optional;

/**
 * Car service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
public interface CarService {

    /**
     * Save Car in DB
     *
     * @param car Car
     * @return Car
     */
    Car addCar(Car car);

    /**
     * Update Car in DB
     *
     * @param car Car
     */
    void updateCar(Car car);

    /**
     * Delete Car by id
     *
     * @param carId Car id
     */
    void deleteCar(int carId);

    /**
     * Find Car by id
     *
     * @param carId Car id
     * @return Optional of Car or empty Optional
     */
    Optional<Car> findCarById(int carId);

    /**
     * Find all Car by Owner id
     *
     * @param ownerId Owner id
     * @return List of Car
     */
    List<Car> findAllCarsByOwnerId(int ownerId);

}
