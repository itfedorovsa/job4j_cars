package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.ReleaseYear;
import ru.job4j.cars.repository.ReleaseYearRepository;

import java.util.List;

/**
 * Release year service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleReleaseYearService implements ReleaseYearService {

    private final ReleaseYearRepository store;

    @Override
    public List<ReleaseYear> findAllReleaseYears() {
        return store.findAllReleaseYears();
    }

    @Override
    public ReleaseYear findReleaseYearById(int releaseYearId) {
        return store.findReleaseYearById(releaseYearId);
    }
}
