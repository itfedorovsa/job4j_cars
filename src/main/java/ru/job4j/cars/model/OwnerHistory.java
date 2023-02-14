package ru.job4j.cars.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * OwnerHistory model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 13.02.23
 */
@Entity
@Getter
@Setter
@Table(name = "owners_history")
public class OwnerHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "owner_id")
    private int ownerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OwnerHistory that = (OwnerHistory) o;
        return id == that.id && carId == that.carId && ownerId == that.ownerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OwnerHistory{"
                + "id=" + id
                + ", carId=" + carId
                + ", ownerId=" + ownerId
                + '}';
    }

}
