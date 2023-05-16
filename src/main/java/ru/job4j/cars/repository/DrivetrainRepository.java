package ru.job4j.cars.repository;

import ru.job4j.cars.model.Drivetrain;

import java.util.List;
import java.util.Optional;

/**
 * Drivetrain repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface DrivetrainRepository {

    /**
     * Find all Drivetrain
     *
     * @return List of Drivetrain
     */
    List<Drivetrain> findAllDrivetrains();

    /**
     * Find Drivetrain by id
     *
     * @param drivetrainId Drivetrain id
     * @return Optional of Drivetrain or empty Optional
     */
    Optional<Drivetrain> findDrivetrainById(int drivetrainId);

}
