package ru.job4j.cars.model;

import lombok.*;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "owners_history")
public class OwnerHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    @Column(name = "car_id")
    private int carId;

    @Column(name = "owner_id")
    private int ownerId;

    @Override
    public String toString() {
        return "OwnerHistory{"
                + "id=" + id
                + ", carId=" + carId
                + ", ownerId=" + ownerId
                + '}';
    }

}
