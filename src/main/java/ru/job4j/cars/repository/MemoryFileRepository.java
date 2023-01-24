package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.File;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * MemoryFile repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class MemoryFileRepository implements FileRepository {

    private final AtomicInteger nextId = new AtomicInteger(0);

    private final Map<Integer, File> files = new ConcurrentHashMap<>();

    /**
     * @param file
     * @return
     */
    @Override
    public File save(File file) {
        file.setId(nextId.incrementAndGet());
        files.put(file.getId(), file);
        return file;
    }

    /**
     * @param fileId
     * @return
     */
    @Override
    public Optional<File> findById(int fileId) {
        return Optional.ofNullable(files.get(fileId));
    }

    /**
     * @param fileId
     * @return
     */
    @Override
    public boolean deleteById(int fileId) {
        return files.remove(fileId) != null;
    }

}
