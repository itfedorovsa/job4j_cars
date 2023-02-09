package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
public class HibernatePostRepository implements PostRepository {

    private static final String DELETE_POST = "DELETE FROM Post WHERE id = :pId";

    private static final String FIND_POST_BY_ID = """
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user
            JOIN FETCH p.priceHistories
            JOIN FETCH p.participates
            JOIN FETCH p.car
            JOIN FETCH p.files
            WHERE p.id = :pId
            """;

    private static final String FIND_POSTS_BY_LAST_DAY = """
            FROM Post
            WHERE created
            BETWEEN :pMinusDay AND :pNow
            """;

    private static final String FIND_WITH_PHOTO = "FROM Post WHERE photo IS NOT NULL";

    private static final String FIND_BY_BRAND_AND_MODEL = "FROM Post WHERE brand = :pBrand AND model = :pModel";

    private final CrudRepository crudRepository;

    /**
     * Save Post in DB
     *
     * @param post Post
     * @return Optional of Post
     */
    @Override
    public Post addPost(Post post) {
        crudRepository.run(session -> session.persist(post));
        return post;
    }

    /**
     * Update Post in DB
     *
     * @param post Post
     */
    @Override
    public void updatePost(Post post) {
        crudRepository.run(session -> session.merge(post));
    }

    /**
     * Delete Post by id
     *
     * @param postId Post id
     */
    @Override
    public void deletePost(int postId) {
        crudRepository.run(
                DELETE_POST,
                Map.of("pId", postId)
        );
    }

    /**
     * Find Post by id
     *
     * @param postId Post id
     * @return Post or NoSuchElementException
     */
    @Override
    public Post findPostById(int postId) {
        Post post = null;
        try {
            post = crudRepository.optional(
                            FIND_POST_BY_ID,
                            Post.class,
                            Map.of("pId", postId))
                    .orElseThrow(() -> new NoSuchElementException("Couldn't find the Post by id."));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return post;
    }

    /**
     * Find posts by last day
     *
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByLastDay() {
        return crudRepository.query(FIND_POSTS_BY_LAST_DAY,
                Post.class,
                Map.of("pMinusDay", LocalDateTime.now().minusDays(1), "pNow", LocalDateTime.now()));
    }

    /**
     * Find posts which contains a photo
     *
     * @return List of Post
     */
    @Override
    public List<Post> findPostsWithPhoto() {
        return crudRepository.query(FIND_WITH_PHOTO, Post.class);
    }

    /**
     * Find all Post by Brand and Model
     *
     * @param brand Brand
     * @param model Model
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByBrandAndModel(String brand, String model) {
        return crudRepository.query(
                FIND_BY_BRAND_AND_MODEL,
                Post.class,
                Map.of("pBrand", brand, "pModel", model)
        );
    }

}
