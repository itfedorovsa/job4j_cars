package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.ReleaseYear;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Hibernate ReleaseYear repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateReleaseYearRepository implements ReleaseYearRepository {

    private static final String FIND_ALL_RELEASE_YEARS_ORDER_BY_YEAR_DESC = "FROM ReleaseYear ORDER BY year DESC";

    private static final String FIND_RELEASE_YEAR_BY_ID = "FROM ReleaseYear WHERE id = :rId";

    private final CrudRepository crudRepository;

    /**
     * Find all ReleaseYear
     *
     * @return List of ReleaseYear
     */
    @Override
    public List<ReleaseYear> findAllReleaseYears() {
        return crudRepository.query(FIND_ALL_RELEASE_YEARS_ORDER_BY_YEAR_DESC, ReleaseYear.class);
    }

    /**
     * Find ReleaseYear by id
     *
     * @param releaseYearId ReleaseYear id
     * @return ReleaseYear or NoSuchElementException
     */
    @Override
    public ReleaseYear findReleaseYearById(int releaseYearId) {
        return crudRepository.optional(
                        FIND_RELEASE_YEAR_BY_ID,
                        ReleaseYear.class,
                        Map.of("rId", releaseYearId))
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the ReleaseYear by id."));
    }

}
