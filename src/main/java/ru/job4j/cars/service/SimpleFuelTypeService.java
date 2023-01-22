package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.FuelType;
import ru.job4j.cars.repository.FuelTypeRepository;

import java.util.List;
import java.util.Optional;

/**
 * Fuel type service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleFuelTypeService implements FuelTypeService {

    private final FuelTypeRepository store;

    @Override
    public List<FuelType> getAllFuelTypes() {
        return store.getAllFuelTypes();
    }

    @Override
    public Optional<FuelType> getFuelTypeById(int id) {
        return store.getFuelTypeById(id);
    }

}
