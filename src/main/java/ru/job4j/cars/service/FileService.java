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

    File saveFile(FileDto fileDto, Post post);

    Optional<FileDto> getFileById(int fileId);

    boolean deleteFileById(int fileId);

    List<FileDto> findAllFilesByPostId(int postId);

}
