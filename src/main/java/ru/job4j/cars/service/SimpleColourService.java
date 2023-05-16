package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Colour;
import ru.job4j.cars.repository.ColourRepository;

import java.util.List;
import java.util.Optional;

/**
 * Colour service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleColourService implements ColourService {

    private final ColourRepository store;

    /**
     * Find all Colour
     *
     * @return List of Colour
     */
    @Override
    public List<Colour> findAllColours() {
        return store.findAllColours();
    }

    /**
     * Find Colour by id
     *
     * @param colourId Colour id
     * @return Optional of Colour or empty Optional
     */
    @Override
    public Optional<Colour> findColourById(int colourId) {
        return store.findColourById(colourId);
    }

}
