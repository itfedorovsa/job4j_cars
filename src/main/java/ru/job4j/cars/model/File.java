package ru.job4j.cars.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * File model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String path;

    @Column(name = "post_id")
    private int postId;

    public File(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public String toString() {
        return "File{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", path='" + path + '\''
                + ", postId=" + postId
                + '}';
    }

}
