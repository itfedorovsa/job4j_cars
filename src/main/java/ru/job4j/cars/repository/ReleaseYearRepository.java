package ru.job4j.cars.repository;

import ru.job4j.cars.model.ReleaseYear;

import java.util.List;
import java.util.Optional;

/**
 * ReleaseYear repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface ReleaseYearRepository {

    List<ReleaseYear> getAllReleaseYears();

    Optional<ReleaseYear> getReleaseYearById(int id);

}
