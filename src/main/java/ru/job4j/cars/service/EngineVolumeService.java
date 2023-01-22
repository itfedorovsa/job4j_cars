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

    List<EngineVolume> getAllEngineVolumes();

    Optional<EngineVolume> getEngineVolumeById(int id);

}
