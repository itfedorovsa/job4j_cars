package ru.job4j.cars.repository;

import ru.job4j.cars.model.Participant;

/**
 * Participant repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.02.23
 */
public interface ParticipantRepository {

    /**
     * Save Participant in DB
     *
     * @param participant Participant
     * @return Participant
     */
    Participant addParticipant(Participant participant);

}
