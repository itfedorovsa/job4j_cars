package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.Map;
import java.util.Optional;

/**
 * Hibernate Car repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateCarRepository implements CarRepository {

    private static final String FIND_CAR_BY_ID = "FROM Car WHERE id = :cId";

    private static final String DELETE_CAR = "DELETE FROM Car WHERE id = :cId";

    private final CrudRepository crudRepository;

    /**
     * Save Car in DB
     *
     * @param car Car
     * @return Optional of Car
     */
    @Override
    public Optional<Car> addCar(Car car) {
        try {
            crudRepository.run(session -> session.persist(car));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return car.getId() == 0 ? Optional.empty() : Optional.of(car);
    }

    /**
     * Update Car in DB
     *
     * @param car Car
     */
    @Override
    public void updateCar(Car car) {
        crudRepository.run(session -> session.merge(car));
    }

    /**
     * Delete Car by id
     *
     * @param carId Car id
     */
    @Override
    public void deleteCar(int carId) {
        crudRepository.run(
                DELETE_CAR,
                Map.of("cId", carId)
        );
    }

    /**
     * Find Car by id
     *
     * @param carId Car id
     * @return Optional of Car
     */
    @Override
    public Optional<Car> findCarById(int carId) {
        return crudRepository.optional(
                FIND_CAR_BY_ID,
                Car.class,
                Map.of("cId", carId));
    }

}
