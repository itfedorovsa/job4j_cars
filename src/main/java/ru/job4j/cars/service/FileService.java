package ru.job4j.cars.service;

import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.File;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * File service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface FileService {

    /**
     * Save File in DB
     *
     * @param fileDto FileDto
     * @param post    Post
     * @return File
     */
    File saveFile(FileDto fileDto, Post post);

    /**
     * Find File by id
     *
     * @param fileId File id
     * @return Optional of File
     */
    Optional<FileDto> getFileById(int fileId);

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
