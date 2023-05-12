package ru.job4j.cars.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Post hibernate repository test class
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.01.23
 */
public class HibernatePostRepositoryTest {

    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();

    private final Session session = sf.openSession();

    private CrudRepository crudRepository;

    private PostRepository postRepository;

    private PriceHistoryRepository priceHistoryRepository;

    private OwnerRepository ownerRepository;

    private UserRepository userRepository;

    private CarRepository carRepository;

    private OwnerHistoryRepository ownerHistoryRepository;

    private ParticipantRepository participantRepository;

    private Post post;

    private Car car;

    private User user;

    private Owner owner;

    private OwnerHistory ownerHistory;

    private PriceHistory priceHistory;

    private Participant participant;

    @BeforeEach
    void initServices() {
        crudRepository = new CrudRepository(sf);
        postRepository = new HibernatePostRepository(crudRepository);
        ownerRepository = new HibernateOwnerRepository(crudRepository);
        userRepository = new HibernateUserRepository(crudRepository);
        priceHistoryRepository = new HibernatePriceHistoryRepository(crudRepository);
        carRepository = new HibernateCarRepository(crudRepository);
        ownerHistoryRepository = new HibernateOwnerHistoryRepository(crudRepository);
        participantRepository = new HibernateParticipantRepository(crudRepository);
        user = User.of()
                .login("login" + System.nanoTime())
                .password("password")
                .name("name")
                .timezone("UTC")
                .phone("123456789123")
                .posts(Set.of())
                .build();
        userRepository.add(user);
        owner = Owner.of()
                .name("name")
                .user(user)
                .build();
        ownerRepository.addOwner(owner);
        Brand brand = new Brand(1, "brand1");
        car = Car.of()
                .brand(brand)
                .model(new ru.job4j.cars.model.Model(1, "model1", brand))
                .vin("11111111111111111")
                .mileage(100)
                .body(new Body(1, "body1"))
                .colour(new Colour(1, "colour1"))
                .releaseYear(new ReleaseYear(1, 2000))
                .engineVolume(new EngineVolume(1, 2.0))
                .owners(Set.of(owner))
                .owner(owner)
                .drivetrain(new Drivetrain(1, "drivetrain1"))
                .transmission(new Transmission(1, "transmission1"))
                .fuelType(new FuelType(1, "fuelType1"))
                .doorCount(new DoorCount(1, "doorCount1"))
                .build();
        owner.setCars(Set.of(car));
        carRepository.addCar(car);
        ownerHistory = new OwnerHistory();
        ownerHistory.setOwnerId(owner.getId());
        ownerHistory.setCarId(car.getId());
        ownerHistoryRepository.addOwnerHistory(ownerHistory);
        priceHistory = PriceHistory.of()
                .before(100)
                .after(200)
                .created(LocalDateTime.now().withSecond(0).withNano(0))
                .postId(1)
                .build();
        participant = new Participant();
        post = Post.of()
                .description("desc1")
                .created(LocalDateTime.now().withSecond(0).withNano(0))
                .user(user)
                .participants(Set.of(user))
                .car(car)
                .price(100)
                .files(List.of())
                .sold(true)
                .build();
    }

    @AfterEach
    public void wipeTable() {
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM participants; DELETE FROM files; DELETE FROM prices_history; "
                            + "DELETE FROM owners_history; DELETE FROM posts; DELETE FROM cars; DELETE FROM owners; "
                            + "DELETE FROM users;")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @AfterAll
    public static void closeConnection() {
        StandardServiceRegistryBuilder.destroy(REGISTRY);
    }

    @Test
    public void whenAddPostThenPostsListSizeIs1() {
        postRepository.addPost(post);
        priceHistory.setPostId(post.getId());
        priceHistoryRepository.addPriceHistory(priceHistory);
        post.setPriceHistories(Set.of(priceHistory));
        participant.setPostId(post.getId());
        participant.setUserId(post.getUser().getId());
        participantRepository.addParticipant(participant);
        assertEquals(1, postRepository.findAllPosts().size());
    }

    @Test
    public void whenDeletePostThenPostDeleted() {
        postRepository.addPost(post);
        priceHistory.setPostId(post.getId());
        priceHistoryRepository.addPriceHistory(priceHistory);
        post.setPriceHistories(Set.of(priceHistory));
        participant.setPostId(post.getId());
        participant.setUserId(post.getUser().getId());
        participantRepository.addParticipant(participant);
        postRepository.deletePost(post);
        assertTrue(postRepository.findAllPosts().isEmpty());
    }

}