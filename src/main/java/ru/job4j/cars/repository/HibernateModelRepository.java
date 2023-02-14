package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Model;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Hibernate Model repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateModelRepository implements ModelRepository {

    private static final String FIND_ALL_MODELS_ORDER_BY_NAME_ASC = "FROM Model WHERE brand_id = :bId ORDER BY name ASC";

    private static final String FIND_MODEL_BY_ID = """
            SELECT DISTINCT m
            FROM Model m
            JOIN FETCH m.brand br
            WHERE m.id = :mId
            """;

    private final CrudRepository crudRepository;

    /**
     * Find all Model by Brand id
     *
     * @param brandId Brand id
     * @return List of Model
     */
    @Override
    public List<Model> getAllModelsByBrandId(int brandId) {
        return crudRepository.query(FIND_ALL_MODELS_ORDER_BY_NAME_ASC,
                Model.class,
                Map.of("bId", brandId)
        );
    }

    /**
     * Find Model by id
     *
     * @param modelId Model id
     * @return Model or NoSuchElementException
     */
    @Override
    public Model getModelById(int modelId) {
        return crudRepository.optional(
                        FIND_MODEL_BY_ID,
                        Model.class,
                        Map.of("mId", modelId))
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Model by id."));
    }

}
