package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.DoorCount;
import ru.job4j.cars.repository.DoorCountRepository;

import java.util.List;
import java.util.Optional;

/**
 * Door count service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleDoorCountService implements DoorCountService {

    private final DoorCountRepository store;

    @Override
    public List<DoorCount> findAllDoorCounts() {
        return store.findAllDoorCounts();
    }

    @Override
    public Optional<DoorCount> findDoorCountById(int doorCountId) {
        return store.findDoorCountById(doorCountId);
    }
}
