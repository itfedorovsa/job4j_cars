package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Owner;
import ru.job4j.cars.repository.OwnerRepository;

import java.util.List;

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

    @Override
    public Owner addOwner(Owner owner) {
        return store.addOwner(owner);
    }

    @Override
    public void updateOwner(Owner owner) {
        store.updateOwner(owner);
    }

    @Override
    public void deleteOwner(int ownerId) {
        store.deleteOwner(ownerId);
    }

    @Override
    public Owner findOwnerById(int ownerId) {
        return store.findOwnerById(ownerId);
    }

    @Override
    public List<Owner> findAllOwnersByCarId(int carId) {
        return store.findAllOwnersByCarId(carId);
    }

}
