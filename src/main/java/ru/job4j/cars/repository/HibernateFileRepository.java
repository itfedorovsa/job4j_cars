package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.File;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate File repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 26.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateFileRepository implements FileRepository {

    private static final String FIND_FILE_BY_ID = "FROM File WHERE id = :fId";

    private static final String DELETE_FILE = "DELETE FROM File WHERE id = :fId";

    private static final String FIND_ALL_FILES_BY_POST_ID = """
            SELECT DISTINCT f
            FROM File f
            JOIN FETCH f.post po
            WHERE po.id = :pId
            """;

    private static final String DELETE_ALL_FILES_BY_POST_ID = """
            DELETE
            FROM File f
            WHERE f.post.id = :pId
            """;

    private final CrudRepository crudRepository;

    /**
     * Save File in DB
     *
     * @param file File
     * @return File
     */
    @Override
    public File saveFile(File file) {
        crudRepository.run(session -> session.save(file));
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
        return crudRepository.optional(
                FIND_FILE_BY_ID,
                File.class,
                Map.of("fId", fileId)
        );
    }

    /**
     * Delete File by id
     *
     * @param fileId File id
     */
    @Override
    public void deleteFileById(int fileId) {
        crudRepository.run(
                DELETE_FILE,
                Map.of("fId", fileId)
        );
    }

    /**
     * Find all File by Post id
     *
     * @param postId Post id
     * @return List of File
     */
    @Override
    public List<File> findAllFilesByPostId(int postId) {
        return crudRepository.query(
                FIND_ALL_FILES_BY_POST_ID,
                File.class,
                Map.of("pId", postId)
        );
    }

    /**
     * Delete all files by Post id
     *
     * @param postId Post id
     */
    @Override
    public void deleteFilesByPostId(int postId) {
        crudRepository.run(
                DELETE_ALL_FILES_BY_POST_ID,
                Map.of("pId", postId)
        );
    }

}
