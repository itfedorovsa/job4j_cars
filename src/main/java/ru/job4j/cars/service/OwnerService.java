package ru.job4j.cars.service;

import ru.job4j.cars.model.Owner;

import java.util.List;

/**
 * Owner service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 24.01.23
 */
public interface OwnerService {

    Owner addOwner(Owner owner);

    void updateOwner(Owner owner);

    void deleteOwner(int ownerId);

    Owner findOwnerById(int ownerId);

    List<Owner> findAllOwnersByCarId(int carId);

}
