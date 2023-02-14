package ru.job4j.cars.repository;

import ru.job4j.cars.model.Drivetrain;

import java.util.List;

/**
 * Drivetrain repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface DrivetrainRepository {

    List<Drivetrain> findAllDrivetrains();

    Drivetrain findDrivetrainById(int drivetrainId);

}
