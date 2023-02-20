package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.PriceHistory;

import java.util.List;
import java.util.Map;

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

    private static final String FIND_ALL_PRICE_HISTORY_BY_POST_ID_ORDER_BY_CREATED_DESC = """
            SELECT DISTINCT p
            FROM PriceHistory p
            JOIN FETCH p.post
            WHERE post_id = :pId ORDER BY created DESC
            """;

    private static final String DELETE_PRICE_HISTORY_BY_POST_ID = """
            DELETE
            FROM PriceHistory p
            WHERE p.post.id = :pId
            """;

    private final CrudRepository crudRepository;

    /**
     * Save PriceHistory in DB
     *
     * @param priceHistory PriceHistory
     * @return PriceHistory
     */
    @Override
    public PriceHistory addPriceHistory(PriceHistory priceHistory) {
        crudRepository.run(session -> session.save(priceHistory));
        return priceHistory;
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
                FIND_ALL_PRICE_HISTORY_BY_POST_ID_ORDER_BY_CREATED_DESC,
                PriceHistory.class,
                Map.of("pId", postId)
        );
    }

    /**
     * Delete all PriceHistory by Post id
     *
     * @param postId Post id
     * @return true if deleted, otherwise false
     */
    @Override
    public void deletePriceHistoryByPostId(int postId) {
        crudRepository.run(DELETE_PRICE_HISTORY_BY_POST_ID,
                Map.of("pId", postId));
    }
}
