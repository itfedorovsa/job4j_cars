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

    /**
     * Save File in DB
     *
     * @param file File
     * @return File
     */
    File saveFile(File file);

    /**
     * Find File by id
     *
     * @param fileId File id
     * @return Optional of File
     */
    Optional<File> findFileById(int fileId);

    /**
     * Delete File by id
     *
     * @param fileId File id
     */
    void deleteFileById(int fileId);

    /**
     * Find all File by Post id
     *
     * @param postId Post id
     * @return List of File
     */
    List<File> findAllFilesByPostId(int postId);

    /**
     * Delete all files by Post id
     *
     * @param postId Post id
     */
    void deleteFilesByPostId(int postId);

}
