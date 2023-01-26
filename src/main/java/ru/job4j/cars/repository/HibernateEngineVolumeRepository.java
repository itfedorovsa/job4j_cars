package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.EngineVolume;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate EngineVolume repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateEngineVolumeRepository implements EngineVolumeRepository {

    private static final String FIND_ALL_ENGINE_VOLUMES = "FROM EngineVolume";

    private static final String FIND_ENGINE_VOLUME_BY_ID = "FROM EngineVolume WHERE id = :eId";

    private final CrudRepository crudRepository;

    /**
     * Find all EngineVolume
     *
     * @return List of EngineVolume
     */
    @Override
    public List<EngineVolume> findAllEngineVolumes() {
        return crudRepository.query(FIND_ALL_ENGINE_VOLUMES, EngineVolume.class);
    }

    /**
     * Find EngineVolume by id
     *
     * @param engineVolumeId EngineVolume id
     * @return Optional of EngineVolume or empty Optional
     */
    @Override
    public Optional<EngineVolume> findEngineVolumeById(int engineVolumeId) {
        return crudRepository.optional(
                FIND_ENGINE_VOLUME_BY_ID,
                EngineVolume.class,
                Map.of("eId", engineVolumeId)
        );
    }

}
