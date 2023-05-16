package ru.job4j.cars.service;

import ru.job4j.cars.model.EngineVolume;

import java.util.List;
import java.util.Optional;

/**
 * EngineVolume service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface EngineVolumeService {

    /**
     * Find all EngineVolume
     *
     * @return List of EngineVolume
     */
    List<EngineVolume> findAllEngineVolumes();

    /**
     * Find EngineVolume by id
     *
     * @param engineVolumeId EngineVolume id
     * @return Optional of EngineVolume or empty Optional
     */
    Optional<EngineVolume> findEngineVolumeById(int engineVolumeId);

}
