package ru.job4j.cars.repository;

import ru.job4j.cars.model.File;

import java.util.Optional;

/**
 * File repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface FileRepository {

    File save(File file);

    Optional<File> findById(int fileId);

    boolean deleteById(int fileId);

}
