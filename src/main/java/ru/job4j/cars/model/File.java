package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * File model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private int id;

    private String name;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public File(String name, String path) {
        this.name = name;
        this.path = path;
    }

}
