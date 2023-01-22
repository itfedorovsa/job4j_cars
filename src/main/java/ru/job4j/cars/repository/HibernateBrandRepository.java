package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Brand;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate Brand repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateBrandRepository implements BrandRepository {

    private static final String FIND_ALL_BRANDS = "FROM Brand";

    private static final String FIND_BRAND_BY_ID = "FROM Brand WHERE id = :pId";

    private final CrudRepository crudRepository;

    /**
     * Find all Brand
     *
     * @return List of Brand
     */
    @Override
    public List<Brand> getAllBrands() {
        return crudRepository.query(FIND_ALL_BRANDS, Brand.class);
    }

    /**
     * Find Brand by id
     *
     * @param id Brand id
     * @return Optional of Brand or empty Optional
     */
    @Override
    public Optional<Brand> getBrandById(int id) {
        return crudRepository.optional(
                FIND_BRAND_BY_ID,
                Brand.class,
                Map.of("pId", id));
    }

}
