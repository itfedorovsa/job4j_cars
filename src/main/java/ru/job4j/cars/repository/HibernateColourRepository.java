package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Colour;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Hibernate Colour repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateColourRepository implements ColourRepository {

    private static final String FIND_ALL_COLOURS_ORDER_BY_NAME_ASC = "FROM Colour ORDER BY name ASC";

    private static final String FIND_COLOUR_BY_ID = "FROM Colour WHERE id = :cId";

    private final CrudRepository crudRepository;

    /**
     * Find all Colour
     *
     * @return List of Colour
     */
    @Override
    public List<Colour> findAllColours() {
        return crudRepository.query(FIND_ALL_COLOURS_ORDER_BY_NAME_ASC, Colour.class);
    }

    /**
     * Find Colour by id
     *
     * @param colourId Colour id
     * @return Colour or NoSuchElementException
     */
    @Override
    public Colour findColourById(int colourId) {
        return crudRepository.optional(
                        FIND_COLOUR_BY_ID,
                        Colour.class,
                        Map.of("cId", colourId))
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Colour by id."));
    }

}
