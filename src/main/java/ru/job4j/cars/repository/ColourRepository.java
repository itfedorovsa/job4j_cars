package ru.job4j.cars.repository;

import ru.job4j.cars.model.Colour;

import java.util.List;
import java.util.Optional;

/**
 * Colour repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface ColourRepository {

    /**
     * Find all Colour
     *
     * @return List of Colour
     */
    List<Colour> findAllColours();

    /**
     * Find Colour by id
     *
     * @param colourId Colour id
     * @return Optional of Colour or empty Optional
     */
    Optional<Colour> findColourById(int colourId);

}
