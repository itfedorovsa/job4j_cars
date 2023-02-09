package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.PriceHistory;
import ru.job4j.cars.repository.PriceHistoryRepository;

import java.util.List;

/**
 * PriceHistory service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimplePriceHistoryService implements PriceHistoryService {

    private final PriceHistoryRepository store;

    @Override
    public PriceHistory addPriceHistory(PriceHistory priceHistory) {
        return store.addPriceHistory(priceHistory);
    }

    @Override
    public List<PriceHistory> findAllPriceHistoryByPostId(int postId) {
        return store.findAllPriceHistoryByPostId(postId);
    }
}
