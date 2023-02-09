package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.DoorCount;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Hibernate DoorCount repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateDoorCountRepository implements DoorCountRepository {

    private static final String FIND_ALL_DOOR_COUNTS_ORDER_BY_AMOUNT_ASC = "FROM DoorCount ORDER BY amount ASC";

    private static final String FIND_DOOR_COUNT_BY_ID = "FROM DoorCount WHERE id = :dId";

    private final CrudRepository crudRepository;

    /**
     * Find all DoorCount
     *
     * @return List of DoorCount
     */
    @Override
    public List<DoorCount> findAllDoorCounts() {
        return crudRepository.query(FIND_ALL_DOOR_COUNTS_ORDER_BY_AMOUNT_ASC, DoorCount.class);
    }

    /**
     * Find DoorCount by id
     *
     * @param doorCountId DoorCount id
     * @return DoorCount or NoSuchElementException
     */
    @Override
    public DoorCount findDoorCountById(int doorCountId) {
        return crudRepository.optional(
                        FIND_DOOR_COUNT_BY_ID,
                        DoorCount.class,
                        Map.of("dId", doorCountId))
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the DoorCount by id."));

    }

}
