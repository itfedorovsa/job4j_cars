package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;

/**
 * EngineVolume model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 19.01.23
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "engine_volumes")
public class EngineVolume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private double volume;

    @Override
    public String toString() {
        return "EngineVolume{"
                + "id=" + id
                + ", volume=" + volume
                + '}';
    }

}
