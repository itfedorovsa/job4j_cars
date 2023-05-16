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

    /**
     * Find all FuelType
     *
     * @return List of FuelType
     */
    @Override
    public List<FuelType> findAllFuelTypes() {
        return store.findAllFuelTypes();
    }

    /**
     * Find FuelType by id
     *
     * @param fuelTypeId FuelType id
     * @return Optional of FuelType or empty Optional
     */
    @Override
    public Optional<FuelType> findFuelTypeById(int fuelTypeId) {
        return store.findFuelTypeById(fuelTypeId);
    }

}
