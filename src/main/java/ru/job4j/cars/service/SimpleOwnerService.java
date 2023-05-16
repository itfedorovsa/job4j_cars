package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Owner;
import ru.job4j.cars.repository.OwnerRepository;

import java.util.List;
import java.util.Optional;

/**
 * Owner service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleOwnerService implements OwnerService {

    private final OwnerRepository store;

    /**
     * Save Owner in DB
     *
     * @param owner Owner
     * @return Optional of Owner
     */
    @Override
    public Owner addOwner(Owner owner) {
        return store.addOwner(owner);
    }

    /**
     * Update Owner in DB
     *
     * @param owner Owner
     */
    @Override
    public void updateOwner(Owner owner) {
        store.updateOwner(owner);
    }

    /**
     * Delete Owner by id
     *
     * @param ownerId Owner id
     */
    @Override
    public void deleteOwner(int ownerId) {
        store.deleteOwner(ownerId);
    }

    /**
     * Find Owner by id
     *
     * @param ownerId Owner id
     * @return Optional of Owner
     */
    @Override
    public Optional<Owner> findOwnerById(int ownerId) {
        return store.findOwnerById(ownerId);
    }

    /**
     * Find all Owner by Car id
     *
     * @param carId Car id
     * @return List of Owner
     */
    @Override
    public List<Owner> findAllOwnersByCarId(int carId) {
        return store.findAllOwnersByCarId(carId);
    }

}
