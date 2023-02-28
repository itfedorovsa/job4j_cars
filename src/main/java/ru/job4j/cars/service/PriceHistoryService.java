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

    PriceHistory addPriceHistory(PriceHistory priceHistory);

    List<PriceHistory> findAllPriceHistoryByPostId(int postId);

    void deletePriceHistoryByPostId(int postId);

}
