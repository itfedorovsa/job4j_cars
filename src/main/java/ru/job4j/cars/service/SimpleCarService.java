package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.repository.CarRepository;

import java.util.Optional;

/**
 * Car service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleCarService implements CarService {

    private final CarRepository store;

    @Override
    public Optional<Car> addCar(Car car) {
        return store.addCar(car);
    }

    @Override
    public void updateCar(Car car) {
        store.updateCar(car);
    }

    @Override
    public void deleteCar(int carId) {
        store.deleteCar(carId);
    }

    @Override
    public Optional<Car> findCarById(int carId) {
        return store.findCarById(carId);
    }

}
