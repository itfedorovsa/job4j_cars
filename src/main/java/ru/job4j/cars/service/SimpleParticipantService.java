package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Participant;
import ru.job4j.cars.repository.ParticipantRepository;

/**
 * Participant service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.02.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimpleParticipantService implements ru.job4j.cars.service.ParticipantService {

    private final ParticipantRepository store;

    /**
     * Save Participant in DB
     *
     * @param participant Participant
     * @return Participant
     */
    @Override
    public Participant addParticipant(Participant participant) {
        return store.addParticipant(participant);
    }

}
