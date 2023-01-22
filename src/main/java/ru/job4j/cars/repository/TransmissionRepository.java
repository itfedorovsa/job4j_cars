package ru.job4j.cars.repository;

import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Optional;

/**
 * Transmission repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface TransmissionRepository {

    List<Transmission> getAllTransmissions();

    Optional<Transmission> getTransmissionById(int id);

}
