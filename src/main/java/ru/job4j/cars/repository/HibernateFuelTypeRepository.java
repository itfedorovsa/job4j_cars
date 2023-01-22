package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.FuelType;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate FuelType repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateFuelTypeRepository implements FuelTypeRepository {

    private static final String FIND_ALL_FUEL_TYPES = "FROM FuelType";

    private static final String FIND_FUEL_TYPE_BY_ID = "FROM FuelType WHERE id = :pId";

    private final CrudRepository crudRepository;

    /**
     * Find all FuelType
     *
     * @return List of FuelType
     */
    @Override
    public List<FuelType> getAllFuelTypes() {
        return crudRepository.query(FIND_ALL_FUEL_TYPES, FuelType.class);
    }

    /**
     * Find FuelType by id
     *
     * @param id FuelType id
     * @return Optional of FuelType or empty Optional
     */
    @Override
    public Optional<FuelType> getFuelTypeById(int id) {
        return crudRepository.optional(
                FIND_FUEL_TYPE_BY_ID,
                FuelType.class,
                Map.of("pId", id));
    }

}
