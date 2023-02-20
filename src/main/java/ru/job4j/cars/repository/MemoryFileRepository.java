package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.cars.model.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Memory File repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@AllArgsConstructor
@ThreadSafe
public class MemoryFileRepository implements FileRepository {

    private final AtomicInteger nextId = new AtomicInteger(0);

    private final Map<Integer, File> files = new ConcurrentHashMap<>();

    /**
     * Save file into memory
     *
     * @param file File
     * @return File with the installed id
     */
    @Override
    public File saveFile(File file) {
        file.setId(nextId.incrementAndGet());
        files.put(file.getId(), file);
        return file;
    }

    /**
     * Find File by id
     *
     * @param fileId File id
     * @return Optional of File
     */
    @Override
    public Optional<File> findFileById(int fileId) {
        return Optional.ofNullable(files.get(fileId));
    }

    /**
     * Delete File by id
     *
     * @param fileId File id
     */
    @Override
    public void deleteFileById(int fileId) {
        files.remove(fileId);
    }

    /**
     * Find all File by Post id
     *
     * @return List of File
     */
    @Override
    public List<File> findAllFilesByPostId(int postId) {
        List<File> filesByPostId = new ArrayList<>();
        for (File file : files.values()) {
            if (file.getPost().getId() == postId) {
                filesByPostId.add(file);
            }
        }
        return filesByPostId;
    }

    @Override
    public void deleteFilesByPostId(int postId) {
        for (File file : files.values()) {
            int fileId = file.getPost().getId();
            if (fileId == postId) {
                files.remove(fileId);
            }
        }
    }

}
