package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Drivetrain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate Drivetrain repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateDrivetrainRepository implements DrivetrainRepository {

    private static final String FIND_ALL_DRIVETRAINS = "FROM Drivetrain";

    private static final String FIND_DRIVETRAIN_BY_ID = "FROM Drivetrain WHERE id = :dId";

    private final CrudRepository crudRepository;

    /**
     * Find all Drivetrain
     *
     * @return List of Drivetrain
     */
    @Override
    public List<Drivetrain> findAllDrivetrains() {
        return crudRepository.query(FIND_ALL_DRIVETRAINS, Drivetrain.class);
    }

    /**
     * Find Drivetrain by id
     *
     * @param drivetrainId Drivetrain id
     * @return Optional of Drivetrain or empty Optional
     */
    @Override
    public Optional<Drivetrain> findDrivetrainById(int drivetrainId) {
        return crudRepository.optional(
                FIND_DRIVETRAIN_BY_ID,
                Drivetrain.class,
                Map.of("dId", drivetrainId));
    }

}
