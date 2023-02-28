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

    List<Colour> findAllColours();

    Optional<Colour> findColourById(int colourId);

}
