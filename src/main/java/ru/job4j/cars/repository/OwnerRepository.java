package ru.job4j.cars.repository;

import ru.job4j.cars.model.Owner;

import java.util.List;

/**
 * Owner repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.01.23
 */
public interface OwnerRepository {

    Owner addOwner(Owner owner);

    void updateOwner(Owner owner);

    void deleteOwner(int ownerId);

    Owner findOwnerById(int ownerId);

    List<Owner> findAllOwnersByCarId(int carId);

}
