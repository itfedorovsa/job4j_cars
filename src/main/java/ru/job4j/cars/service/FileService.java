package ru.job4j.cars.service;

import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.File;

import java.util.Optional;

/**
 * File service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface FileService {

    File save(FileDto fileDto);

    Optional<FileDto> getFileById(int id);

    boolean deleteById(int id);

}
