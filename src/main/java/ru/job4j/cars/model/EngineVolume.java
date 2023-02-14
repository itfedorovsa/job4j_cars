package ru.job4j.cars.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

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
@Table(name = "engine_volumes")
public class EngineVolume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EngineVolume that = (EngineVolume) o;
        return id == that.id && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EngineVolume{"
                + "id=" + id
                + ", volume=" + volume
                + '}';
    }

}
