package ru.job4j.cars.service;

import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Optional;

/**
 * Transmission service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface TransmissionService {

    /**
     * Find all Transmission
     *
     * @return List of Transmission
     */
    List<Transmission> findAllTransmissions();

    /**
     * Find Transmission by id
     *
     * @param transmissionId Transmission id
     * @return Optional of Transmission or empty Optional
     */
    Optional<Transmission> findTransmissionById(int transmissionId);

}
