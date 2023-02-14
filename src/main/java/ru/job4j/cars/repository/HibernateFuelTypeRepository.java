package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.FuelType;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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

    private static final String FIND_ALL_FUEL_TYPES_ORDER_BY_TYPE_ASC = "FROM FuelType ORDER BY type ASC";

    private static final String FIND_FUEL_TYPE_BY_ID = "FROM FuelType WHERE id = :fId";

    private final CrudRepository crudRepository;

    /**
     * Find all FuelType
     *
     * @return List of FuelType
     */
    @Override
    public List<FuelType> findAllFuelTypes() {
        return crudRepository.query(FIND_ALL_FUEL_TYPES_ORDER_BY_TYPE_ASC, FuelType.class);
    }

    /**
     * Find FuelType by id
     *
     * @param fuelTypeId FuelType id
     * @return FuelType or NoSuchElementException
     */
    @Override
    public FuelType findFuelTypeById(int fuelTypeId) {
        return crudRepository.optional(
                        FIND_FUEL_TYPE_BY_ID,
                        FuelType.class,
                        Map.of("fId", fuelTypeId))
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the FuelType by id."));

    }

}
