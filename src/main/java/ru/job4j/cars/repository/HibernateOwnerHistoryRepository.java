package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.OwnerHistory;

/**
 * Hibernate OwnerHistory repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 13.02.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateOwnerHistoryRepository implements OwnerHistoryRepository {

    private final CrudRepository crudRepository;

    /**
     * Save OwnerHistory in DB
     *
     * @param ownerHistory OwnerHistory
     * @return OwnerHistory
     */
    @Override
    public OwnerHistory addOwnerHistory(OwnerHistory ownerHistory) {
        crudRepository.run(session -> session.save(ownerHistory));
        return ownerHistory;
    }

}
