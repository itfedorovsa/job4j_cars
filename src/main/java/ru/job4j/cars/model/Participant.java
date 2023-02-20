package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;

/**
 * Participant model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.02.23
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "user_id")
    private int userId;

    @Override
    public String toString() {
        return "Participant{"
                + "id=" + id
                + ", postId=" + postId
                + ", userId=" + userId
                + '}';
    }

}
