package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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

    private static final String FIND_ALL_TRANSMISSIONS_ORDER_BY_TYPE_ASC = "FROM Transmission ORDER BY type ASC";

    private static final String FIND_TRANSMISSION_BY_ID = "FROM Transmission WHERE id = :tId";

    private final CrudRepository crudRepository;

    /**
     * Find all Transmission
     *
     * @return List of Transmission
     */
    @Override
    public List<Transmission> findAllTransmissions() {
        return crudRepository.query(FIND_ALL_TRANSMISSIONS_ORDER_BY_TYPE_ASC, Transmission.class);
    }

    /**
     * Find Transmission by id
     *
     * @param transmissionId Transmission id
     * @return Transmission or NoSuchElementException
     */
    @Override
    public Transmission findTransmissionById(int transmissionId) {
        return crudRepository.optional(
                        FIND_TRANSMISSION_BY_ID,
                        Transmission.class,
                        Map.of("tId", transmissionId))
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Transmission by id."));
    }

}
