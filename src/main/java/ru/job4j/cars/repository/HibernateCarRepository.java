package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;

/**
 * Hibernate Car repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 09.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateCarRepository implements CarRepository {

    private final CrudRepository crudRepository;

}
