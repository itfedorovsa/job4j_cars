package ru.job4j.cars.repository;

import ru.job4j.cars.model.DoorCount;

import java.util.List;

/**
 * DoorCount repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface DoorCountRepository {

    List<DoorCount> findAllDoorCounts();

    DoorCount findDoorCountById(int doorCountId);

}
