package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Drivetrain;
import ru.job4j.cars.repository.DrivetrainRepository;

import java.util.List;
import java.util.Optional;

/**
 * Drivetrain service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleDrivetrainService implements DrivetrainService {

    private final DrivetrainRepository store;

    /**
     * Find all Drivetrain
     *
     * @return List of Drivetrain
     */
    @Override
    public List<Drivetrain> findAllDrivetrains() {
        return store.findAllDrivetrains();
    }

    /**
     * Find Drivetrain by id
     *
     * @param drivetrainId Drivetrain id
     * @return Optional of Drivetrain or empty Optional
     */
    @Override
    public Optional<Drivetrain> findDrivetrainById(int drivetrainId) {
        return store.findDrivetrainById(drivetrainId);
    }

}
