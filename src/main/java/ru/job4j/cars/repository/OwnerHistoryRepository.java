package ru.job4j.cars.repository;

import ru.job4j.cars.model.OwnerHistory;

/**
 * OwnerHistory repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 13.02.23
 */
public interface OwnerHistoryRepository {

    /**
     * Save OwnerHistory in DB
     *
     * @param ownerHistory OwnerHistory
     * @return OwnerHistory
     */
    OwnerHistory addOwnerHistory(OwnerHistory ownerHistory);

}
