package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Price history model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.12.22
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(builderMethodName = "of")
@Table(name = "prices_history")
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private int before;

    private int after;

    private LocalDateTime created = LocalDateTime.now().withSecond(0).withNano(0);

    @Column(name = "post_id")
    private int postId;

    public PriceHistory(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PriceHistory{"
                + "id=" + id
                + ", before=" + before
                + ", after=" + after
                + ", created=" + created
                + ", postId=" + postId
                + '}';
    }

}
