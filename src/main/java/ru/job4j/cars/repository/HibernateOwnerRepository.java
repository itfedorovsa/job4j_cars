package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Owner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Hibernate Owner repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateOwnerRepository implements OwnerRepository {

    private static final String DELETE_OWNER = "DELETE FROM Owner WHERE id = :oId";

    private static final String FIND_OWNER_BY_ID = """
            SELECT DISTINCT o
            FROM Owner o
            JOIN FETCH o.user
            WHERE o.id = :oId
            """;

    private static final String FIND_ALL_OWNERS_BY_CAR_ID = """
            SELECT DISTINCT o
            FROM Owner o
            JOIN FETCH o.cars WHERE car_id = :cId
            """;

    private final CrudRepository crudRepository;

    /**
     * Save Owner in DB
     *
     * @param owner Owner
     * @return Owner
     */
    @Override
    public Owner addOwner(Owner owner) {
        crudRepository.run(session -> session.save(owner));
        return owner;
    }

    /**
     * Update Owner in DB
     *
     * @param owner Owner
     */
    @Override
    public void updateOwner(Owner owner) {
        crudRepository.run(session -> session.update(owner));
    }

    /**
     * Delete Owner by id
     *
     * @param ownerId Owner id
     */
    @Override
    public void deleteOwner(int ownerId) {
        crudRepository.run(
                DELETE_OWNER,
                Map.of("oId", ownerId)
        );
    }

    /**
     * Find Owner by id
     *
     * @param ownerId Owner id
     * @return Optional of Owner or empty Optional
     */
    @Override
    @Transactional
    public Optional<Owner> findOwnerById(int ownerId) {
        return crudRepository.optional(
                FIND_OWNER_BY_ID,
                Owner.class,
                Map.of("oId", ownerId)
        );
    }

    /**
     * Find all Owner by Car id
     *
     * @param carId Car id
     * @return List of Owner
     */
    @Override
    public List<Owner> findAllOwnersByCarId(int carId) {
        return crudRepository.query(
                FIND_ALL_OWNERS_BY_CAR_ID,
                Owner.class,
                Map.of("cId", carId)
        );
    }

}
