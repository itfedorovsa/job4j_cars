package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

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
    public List<Brand> getAllBrands() {
        return store.getAllBrands();
    }

    @Override
    public Optional<Brand> getBrandById(int id) {
        return store.getBrandById(id);
    }
}
