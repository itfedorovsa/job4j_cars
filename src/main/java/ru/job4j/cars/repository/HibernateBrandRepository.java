package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Brand;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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

    private static final String FIND_ALL_BRANDS_ORDER_BY_NAME_ASC = "FROM Brand ORDER BY name ASC";

    private static final String FIND_BRAND_BY_ID = "FROM Brand WHERE id = :bId";

    private final CrudRepository crudRepository;

    /**
     * Find all Brand
     *
     * @return List of Brand
     */
    @Override
    public List<Brand> findAllBrands() {
        return crudRepository.query(FIND_ALL_BRANDS_ORDER_BY_NAME_ASC, Brand.class);
    }

    /**
     * Find Brand by id
     *
     * @param brandId Brand id
     * @return Brand or NoSuchElementException
     */
    @Override
    public Brand findBrandById(int brandId) {
        return crudRepository.optional(
                        FIND_BRAND_BY_ID,
                        Brand.class,
                        Map.of("bId", brandId))
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Brand by id."));
    }

}
