package ru.job4j.cars;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.CrudRepository;
import ru.job4j.cars.repository.HibernateUserRepository;

import java.util.Optional;

/**
 * User usage demo class
 */
public class UserUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var userRepository = new HibernateUserRepository(new CrudRepository(sf));
            var user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            Optional<User> userOpt = userRepository.add(user);
            userRepository.findAllUsersOrderById()
                    .forEach(System.out::println);
            userRepository.findUserByLikeLogin("e")
                    .forEach(System.out::println);
            System.out.println(userRepository.findUserByLikeLogin("adm"));
            userRepository.findUserById(user.getId())
                    .ifPresent(System.out::println);
            userRepository.findUserByLogin("admin")
                    .ifPresent(System.out::println);
            user.setPassword("password");
            userRepository.update(user);
            userRepository.findUserById(user.getId())
                    .ifPresent(System.out::println);
            userRepository.delete(user.getId());
            userRepository.findAllUsersOrderById()
                    .forEach(System.out::println);
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}