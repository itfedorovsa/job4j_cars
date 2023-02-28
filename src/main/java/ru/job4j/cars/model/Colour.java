package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;

/**
 * Colour model
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
@Table(name = "colours")
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    @Override
    public String toString() {
        return "Colour{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }

}
