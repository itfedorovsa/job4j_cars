package ru.job4j.cars.service;

import ru.job4j.cars.model.Participant;

/**
 * Participant service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.02.23
 */
public interface ParticipantService {

    /**
     * Save Participant in DB
     *
     * @param participant Participant
     * @return Participant
     */
    Participant addParticipant(Participant participant);

}
