package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

/**
 * Transmission model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 19.01.23
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "transmissions")
public class Transmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    private String type;

}
