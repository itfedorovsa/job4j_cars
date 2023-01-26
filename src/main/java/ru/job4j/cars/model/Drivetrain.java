package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

/**
 * Drive model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "drivetrains")
public class Drivetrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    private String type;

}
