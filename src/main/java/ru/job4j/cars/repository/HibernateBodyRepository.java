package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Body;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate Body repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateBodyRepository implements BodyRepository {

    private static final String FIND_ALL_BODIES = "FROM Body";

    private static final String FIND_BODY_BY_ID = "FROM Body WHERE id = :pId";

    private final CrudRepository crudRepository;

    /**
     * Find all Body
     *
     * @return List of Body
     */
    @Override
    public List<Body> getAllBodies() {
        return crudRepository.query(FIND_ALL_BODIES, Body.class);
    }

    /**
     * Find Body by id
     *
     * @param id Body id
     * @return Optional of Body or empty Optional
     */
    @Override
    public Optional<Body> getBodyById(int id) {
        return crudRepository.optional(
                FIND_BODY_BY_ID,
                Body.class,
                Map.of("pId", id));
    }

}
