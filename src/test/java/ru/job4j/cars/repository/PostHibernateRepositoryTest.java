package ru.job4j.cars.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Post;

import static org.assertj.core.api.Assertions.*;

/**
 * Post hibernate repository test class
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.01.23
 */
public class PostHibernateRepositoryTest {

    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();

    private final Session session = sf.openSession();

    CrudRepository crudRepository = new CrudRepository(sf);

    PostHibernateRepository repository = new PostHibernateRepository(crudRepository);

    @AfterEach
    public void wipeTable() {
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM Item")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @AfterAll
    static void close() {
        StandardServiceRegistryBuilder.destroy(REGISTRY);
    }

    /*@Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new PostHibernateRepository(sf)) {
            Post post = new Post();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName(), is(item.getName()));
        }
    }*/
}