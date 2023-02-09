package ru.job4j.cars.repository;

import ru.job4j.cars.model.Transmission;

import java.util.List;

/**
 * Transmission repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface TransmissionRepository {

    List<Transmission> findAllTransmissions();

    Transmission findTransmissionById(int transmissionId);

}
