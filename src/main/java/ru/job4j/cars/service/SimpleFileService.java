package ru.job4j.cars.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.File;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.FileRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * File service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@ThreadSafe
public class SimpleFileService implements FileService {

    private final FileRepository store;

    private final String storageDirectory;

    public SimpleFileService(FileRepository store, @Value("${file.directory}") String storageDirectory) {
        this.store = store;
        this.storageDirectory = storageDirectory;
        createStorageDirectory(storageDirectory);
    }

    /**
     * Create storage directory
     *
     * @param path parameter "file.directory" from application.properties
     */
    private void createStorageDirectory(String path) {
        try {
            Files.createDirectories(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Save File from FileDto to File storage
     *
     * @param fileDto FileDto
     * @param post    Post
     * @return File
     */
    @Override
    public File saveFile(FileDto fileDto, Post post) {
        String path = getNewFilePath(fileDto.getName());
        writeFileBytes(path, fileDto.getContent());
        File file = new File(fileDto.getName(), path);
        file.setPost(post);
        return store.saveFile(file);
    }

    /**
     * Create random string of a certain format
     *
     * @param sourceName FileDto's name
     * @return String
     */
    private String getNewFilePath(String sourceName) {
        return storageDirectory + java.io.File.separator + UUID.randomUUID() + sourceName;
    }

    /**
     * Write content in file storage
     *
     * @param path    Generated random path
     * @param content File content
     */
    private void writeFileBytes(String path, byte[] content) {
        try {
            Files.write(Path.of(path), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Find FindDto by id
     *
     * @param fileId File id
     * @return Optional of FileDto
     */
    @Override
    public Optional<FileDto> getFileById(int fileId) {
        Optional<File> fileOptional = store.findFileById(fileId);
        if (fileOptional.isEmpty()) {
            return Optional.empty();
        }
        byte[] content = readFileAsBytes(fileOptional.get().getPath());
        return Optional.of(new FileDto(fileOptional.get().getName(), content));
    }

    /**
     * Read content from file
     *
     * @param path Content source
     * @return byte array
     */
    private byte[] readFileAsBytes(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete file from repository
     *
     * @param fileId File id
     * @return true if deleted, otherwise false
     */
    @Override
    public boolean deleteFileById(int fileId) {
        Optional<File> fileOptional = store.findFileById(fileId);
        if (fileOptional.isEmpty()) {
            return false;
        }
        deleteFile(fileOptional.get().getPath());
        return store.deleteFileById(fileId);
    }

    /**
     * Delete file at the specified path
     *
     * @param path Source file path
     */
    private void deleteFile(String path) {
        try {
            Files.deleteIfExists(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param postId Post id
     * @return List of FileDto
     */
    @Override
    public List<FileDto> findAllFilesByPostId(int postId) {
        List<File> filesByPostId = store.findAllFilesByPostId(postId);
        List<FileDto> filesDtoByPostId = new ArrayList<>();
        for (File file : filesByPostId) {
            byte[] content = readFileAsBytes(file.getPath());
            filesDtoByPostId.add(new FileDto(file.getName(), content));
        }
        return filesDtoByPostId;
    }

}
