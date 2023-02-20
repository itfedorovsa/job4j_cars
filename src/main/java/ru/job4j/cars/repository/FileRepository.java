package ru.job4j.cars.repository;

import ru.job4j.cars.model.File;

import java.util.List;
import java.util.Optional;

/**
 * File repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface FileRepository {

    File saveFile(File file);

    Optional<File> findFileById(int fileId);

    void deleteFileById(int fileId);

    List<File> findAllFilesByPostId(int postId);

    void deleteFilesByPostId(int postId);

}
