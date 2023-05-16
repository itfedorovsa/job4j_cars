package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.OwnerHistory;
import ru.job4j.cars.repository.OwnerHistoryRepository;

/**
 * OwnerHistory service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 13.02.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleOwnerHistoryService implements OwnerHistoryService {

    private final OwnerHistoryRepository store;

    /**
     * Save OwnerHistory in DB
     *
     * @param ownerHistory OwnerHistory
     * @return OwnerHistory
     */
    @Override
    public OwnerHistory addOwnerHistory(OwnerHistory ownerHistory) {
        return store.addOwnerHistory(ownerHistory);
    }

}
