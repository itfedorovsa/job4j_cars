package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.EngineVolume;
import ru.job4j.cars.repository.EngineVolumeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Engine volume service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleEngineVolumeService implements EngineVolumeService {

    private final EngineVolumeRepository store;

    /**
     * Find all EngineVolume
     *
     * @return List of EngineVolume
     */
    @Override
    public List<EngineVolume> findAllEngineVolumes() {
        return store.findAllEngineVolumes();
    }

    /**
     * Find EngineVolume by id
     *
     * @param engineVolumeId EngineVolume id
     * @return Optional of EngineVolume or empty Optional
     */
    @Override
    public Optional<EngineVolume> findEngineVolumeById(int engineVolumeId) {
        return store.findEngineVolumeById(engineVolumeId);
    }

}
