package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * User model
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 23.11.22
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder(builderMethodName = "of")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String login;

    private String password;

    private String name;

    private String timezone;

    private String phone;

    @ManyToMany(mappedBy = "participants", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Post> posts = new HashSet<>();

    public User(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", name='" + name + '\'' + ", timezone='" + timezone + '\''
                + ", phone='" + phone + '\''
                + '}';
    }

}