package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.DoorCount;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    private static final String FIND_ALL_DOOR_COUNTS = "FROM DoorCount";

    private static final String FIND_DOOR_COUNT_BY_ID = "FROM DoorCount WHERE id = :pId";

    private final CrudRepository crudRepository;

    /**
     * Find all DoorCount
     *
     * @return List of DoorCount
     */
    @Override
    public List<DoorCount> getAllDoorCounts() {
        return crudRepository.query(FIND_ALL_DOOR_COUNTS, DoorCount.class);
    }

    /**
     * Find DoorCount by id
     *
     * @param id DoorCount id
     * @return Optional of DoorCount or empty Optional
     */
    @Override
    public Optional<DoorCount> getDoorCountById(int id) {
        return crudRepository.optional(
                FIND_DOOR_COUNT_BY_ID,
                DoorCount.class,
                Map.of("pId", id));
    }

}
