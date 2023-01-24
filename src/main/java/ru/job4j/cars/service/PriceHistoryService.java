package ru.job4j.cars.service;

import ru.job4j.cars.model.PriceHistory;

import java.util.List;
import java.util.Optional;

/**
 * PriceHistory service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
public interface PriceHistoryService {

    Optional<PriceHistory> addPriceHistory(PriceHistory priceHistory);

    List<PriceHistory> findAllPriceHistoryByPostId(int postId);

}
