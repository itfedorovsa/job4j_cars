package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.PriceHistory;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate PriceHistory repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernatePriceHistoryRepository implements PriceHistoryRepository {

    private static final String FIND_ALL_PRICE_HISTORY_BY_POST_ID = """
            SELECT DISTINCT p
            FROM PriceHistory p
            JOIN FETCH p.post
            WHERE post_id = :pId
            """;

    private final CrudRepository crudRepository;

    /**
     * Save PriceHistory in DB
     *
     * @param priceHistory PriceHistory
     * @return Optional of PriceHistory
     */
    @Override
    public Optional<PriceHistory> addPriceHistory(PriceHistory priceHistory) {
        try {
            crudRepository.run(session -> session.persist(priceHistory));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return priceHistory.getId() == 0 ? Optional.empty() : Optional.of(priceHistory);
    }

    /**
     * Find all PriceHistory by Post id
     *
     * @param postId Post id
     * @return List of PriceHistory
     */
    @Override
    public List<PriceHistory> findAllPriceHistoryByPostId(int postId) {
        return crudRepository.query(
                FIND_ALL_PRICE_HISTORY_BY_POST_ID,
                PriceHistory.class,
                Map.of("pId", postId)
        );
    }

}
