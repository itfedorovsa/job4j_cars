package ru.job4j.cars.service;

import ru.job4j.cars.model.PriceHistory;

import java.util.List;

/**
 * PriceHistory service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
public interface PriceHistoryService {

    /**
     * Save PriceHistory in DB
     *
     * @param priceHistory PriceHistory
     * @return PriceHistory
     */
    PriceHistory addPriceHistory(PriceHistory priceHistory);

    /**
     * Find all PriceHistory by Post id
     *
     * @param postId Post id
     * @return List of PriceHistory
     */
    List<PriceHistory> findAllPriceHistoryByPostId(int postId);

    /**
     * Delete all PriceHistory by Post id
     *
     * @param postId Post id
     */
    void deletePriceHistoryByPostId(int postId);

}
