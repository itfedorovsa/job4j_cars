package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;

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

    private final CrudRepository crudRepository;

}
