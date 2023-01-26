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

    Optional<Car> addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int carId);

    Optional<Car> findCarById(int carId);

    List<Car> findAllCarsByOwnerId(int ownerId);

}
