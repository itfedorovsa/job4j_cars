package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.repository.BrandRepository;

import java.util.List;

/**
 * Brand service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleBrandService implements BrandService {

    private final BrandRepository store;

    @Override
    public List<Brand> findAllBrands() {
        return store.findAllBrands();
    }

    @Override
    public Brand findBrandById(int brandId) {
        return store.findBrandById(brandId);
    }
}
