package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Participant;

/**
 * Hibernate Participant repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 13.02.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class HibernateParticipantRepository implements ParticipantRepository {

    private final CrudRepository crudRepository;

    /**
     * Save Participant in DB
     *
     * @param participant Participant
     * @return Participant
     */
    @Override
    public Participant addParticipant(Participant participant) {
        crudRepository.run(session -> session.save(participant));
        return participant;
    }

}
