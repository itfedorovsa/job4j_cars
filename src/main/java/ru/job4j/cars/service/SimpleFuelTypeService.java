package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.FuelType;
import ru.job4j.cars.repository.FuelTypeRepository;

import java.util.List;

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
    public List<FuelType> findAllFuelTypes() {
        return store.findAllFuelTypes();
    }

    @Override
    public FuelType findFuelTypeById(int fuelTypeId) {
        return store.findFuelTypeById(fuelTypeId);
    }

}
