package ru.job4j.cars.repository;

import ru.job4j.cars.model.Car;

import java.util.List;

/**
 * Car repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.01.23
 */
public interface CarRepository {

    Car addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int carId);

    Car findCarById(int carId);

    List<Car> findAllCarsByOwnerId(int ownerId);

}
