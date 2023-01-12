package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Hibernate Post repository
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 10.01.23
 */
@Repository
@AllArgsConstructor
@ThreadSafe
public class PostHibernateRepository implements PostRepository {

    private final CrudRepository crudRepository;

    private static final String FIND_BY_LAST_DAY = """
            SELECT date(created) FROM Post WHERE date(created) = :pYesterday
            """;

    private static final String FIND_WITH_PHOTO = "FROM Post WHERE photo IS NOT NULL";

    private static final String FIND_BY_BRAND_AND_MODEL = "FROM Post WHERE brand = :pBrand AND model = :pModel";

    @Override
    public List<Post> findPostsByLastDay() {
        return crudRepository.query(FIND_BY_LAST_DAY, Post.class, Map.of("pYesterday", LocalDate.now().minusDays(1)));
    }

    @Override
    public List<Post> findPostsWithPhoto() {
        return crudRepository.query(FIND_WITH_PHOTO, Post.class);
    }

    @Override
    public List<Post> findPostsByBrandAndModel(String brand, String model) {
        return crudRepository.query(
                FIND_BY_BRAND_AND_MODEL,
                Post.class,
                Map.of("pBrand", brand, "pModel", model));
    }

}
