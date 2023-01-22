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

    @Override
    public List<Colour> getAllColours() {
        return store.getAllColours();
    }

    @Override
    public Optional<Colour> getColourById(int id) {
        return store.getColourById(id);
    }
}
