package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Transmission;
import ru.job4j.cars.repository.TransmissionRepository;

import java.util.List;
import java.util.Optional;

/**
 * Transmission service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleTransmissionService implements TransmissionService {

    private final TransmissionRepository store;

    /**
     * Find all Transmission
     *
     * @return List of Transmission
     */
    @Override
    public List<Transmission> findAllTransmissions() {
        return store.findAllTransmissions();
    }

    /**
     * Find Transmission by id
     *
     * @param transmissionId Transmission id
     * @return Optional of Transmission or empty Optional
     */
    @Override
    public Optional<Transmission> findTransmissionById(int transmissionId) {
        return store.findTransmissionById(transmissionId);
    }

}
