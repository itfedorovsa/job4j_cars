package ru.job4j.cars.service;

import ru.job4j.cars.model.Car;

import java.util.List;

/**
 * Car service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
public interface CarService {

    Car addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int carId);

    Car findCarById(int carId);

    List<Car> findAllCarsByOwnerId(int ownerId);

}
