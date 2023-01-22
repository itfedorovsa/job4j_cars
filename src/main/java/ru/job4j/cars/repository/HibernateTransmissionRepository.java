package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate Transmission repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateTransmissionRepository implements TransmissionRepository {

    private static final String FIND_ALL_TRANSMISSIONS = "FROM Transmission";

    private static final String FIND_TRANSMISSION_BY_ID = "FROM Transmission WHERE id = :pId";

    private final CrudRepository crudRepository;

    /**
     * Find all Transmission
     *
     * @return List of Transmission
     */
    @Override
    public List<Transmission> getAllTransmissions() {
        return crudRepository.query(FIND_ALL_TRANSMISSIONS, Transmission.class);
    }

    /**
     * Find Transmission by id
     *
     * @param id Transmission id
     * @return Optional of Transmission or empty Optional
     */
    @Override
    public Optional<Transmission> getTransmissionById(int id) {
        return crudRepository.optional(
                FIND_TRANSMISSION_BY_ID,
                Transmission.class,
                Map.of("pId", id));
    }

}
