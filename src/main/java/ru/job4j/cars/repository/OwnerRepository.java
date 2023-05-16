package ru.job4j.cars.repository;

import ru.job4j.cars.model.Owner;

import java.util.List;
import java.util.Optional;

/**
 * Owner repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.01.23
 */
public interface OwnerRepository {

    /**
     * Save Owner in DB
     *
     * @param owner Owner
     * @return Optional of Owner
     */
    Owner addOwner(Owner owner);

    /**
     * Update Owner in DB
     *
     * @param owner Owner
     */
    void updateOwner(Owner owner);

    /**
     * Delete Owner by id
     *
     * @param ownerId Owner id
     */
    void deleteOwner(int ownerId);

    /**
     * Find Owner by id
     *
     * @param ownerId Owner id
     * @return Optional of Owner
     */
    Optional<Owner> findOwnerById(int ownerId);

    /**
     * Find all Owner by Car id
     *
     * @param carId Car id
     * @return List of Owner
     */
    List<Owner> findAllOwnersByCarId(int carId);

}
