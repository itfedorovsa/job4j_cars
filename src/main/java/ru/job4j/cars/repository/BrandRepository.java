package ru.job4j.cars.repository;

import ru.job4j.cars.model.Brand;

import java.util.List;
import java.util.Optional;

/**
 * Brand repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface BrandRepository {

    List<Brand> findAllBrands();

    Optional<Brand> findBrandById(int brandId);

}
