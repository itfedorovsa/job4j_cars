package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;

/**
 * Engine type model
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
@Table(name = "fuel_types")
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String type;

    @Override
    public String toString() {
        return "FuelType{"
                + "id=" + id
                + ", type='" + type + '\''
                + '}';
    }

}
