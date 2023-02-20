package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;

/**
 * Door count model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "doors")
public class DoorCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String amount;

    @Override
    public String toString() {
        return "DoorCount{"
                + "id=" + id
                + ", amount='" + amount + '\''
                + '}';
    }

}
