package ru.job4j.cars.service;

import ru.job4j.cars.model.Colour;

import java.util.List;
import java.util.Optional;

/**
 * Colour service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface ColourService {

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
