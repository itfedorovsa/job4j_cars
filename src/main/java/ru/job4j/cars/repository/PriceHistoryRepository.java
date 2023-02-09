package ru.job4j.cars.repository;

import ru.job4j.cars.model.PriceHistory;

import java.util.List;

/**
 * PriceHistory repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
public interface PriceHistoryRepository {

    PriceHistory addPriceHistory(PriceHistory priceHistory);

    List<PriceHistory> findAllPriceHistoryByPostId(int postId);

}
