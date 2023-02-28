package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    private static final String FIND_POST_BY_ID = """ 
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants pas
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE p.id = :pId
            """;

    private static final String FIND_POSTS_BY_LAST_DAY = """
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE p.created
            BETWEEN :pMinusDay AND :pNow
            """;

    private static final String FIND_WITH_PHOTO = "FROM Post WHERE photo IS NOT NULL";

    private static final String FIND_BY_BRAND_ID = """       
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE br.id = :bId
            """;

    private static final String FIND_BY_RELEASE_YEAR_ID = """       
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE re.id = :rId
            """;

    private static final String FIND_BY_BODY_ID = """       
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE bo.id = :bId
            """;

    private static final String FIND_BY_COLOUR_ID = """       
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE co.id = :cId
            """;

    private static final String FIND_BY_TRANSMISSION_ID = """       
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE tr.id = :tId
            """;

    private static final String FIND_BY_DRIVETRAIN_ID = """       
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE dr.id = :dId
            """;

    private static final String FIND_BY_ENGINE_VOLUME_ID = """       
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE en.id = :eId
            """;

    private static final String FIND_POST_BY_USER_ID = """ 
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE u.id = :uId
            """;

    private static final String FIND_FAVOURITE_POSTS = """ 
            SELECT DISTINCT p
            FROM Post p
            JOIN FETCH p.user u
            JOIN FETCH p.priceHistories prs
            JOIN FETCH p.participants par
            JOIN FETCH p.car ca
            JOIN FETCH ca.brand br
            JOIN FETCH ca.model mo
            JOIN FETCH ca.body bo
            JOIN FETCH ca.colour co
            JOIN FETCH ca.releaseYear re
            JOIN FETCH ca.engineVolume en
            JOIN FETCH ca.drivetrain dr
            JOIN FETCH ca.fuelType fu
            JOIN FETCH ca.doorCount do
            JOIN FETCH ca.transmission tr
            JOIN FETCH ca.owner ow
            JOIN FETCH ow.user us
            JOIN FETCH ow.cars crs
            JOIN FETCH ca.owners ows
            JOIN FETCH p.files fi
            WHERE p.id IN (
            SELECT pa.postId FROM Participant pa
            WHERE pa.userId = :uId)
            """;

    private final CrudRepository crudRepository;

    /**
     * Save Post in DB
     *
     * @param post Post
     * @return Optional of Post
     */
    @Override
    public Post addPost(Post post) {
        crudRepository.run(session -> session.save(post));
        return post;
    }

    /**
     * Update Post in DB
     *
     * @param post Post
     */
    @Override
    public void updatePost(Post post) {
        crudRepository.run(session -> session.update(post));
    }

    /**
     * Delete Post
     *
     * @param post Post
     */
    @Override
    public void deletePost(Post post) {
        crudRepository.run(session -> session.delete(post));
    }

    /**
     * Find Post by id
     *
     * @param postId Post id
     * @return Optional of Post
     */
    @Override
    public Optional<Post> findPostById(int postId) {
        return crudRepository.optional(
                FIND_POST_BY_ID,
                Post.class,
                Map.of("pId", postId)
        );
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
     * Find posts which have a photo
     *
     * @return List of Post
     */
    @Override
    public List<Post> findPostsWithPhoto() {
        return crudRepository.query(FIND_WITH_PHOTO, Post.class);
    }

    /**
     * Find all Post by Brand id
     *
     * @param brandId Brand id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByBrandId(int brandId) {
        return crudRepository.query(
                FIND_BY_BRAND_ID,
                Post.class,
                Map.of("bId", brandId)
        );
    }

    /**
     * Find all Post by ReleaseYear id
     *
     * @param releaseYearId ReleaseYear id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByReleaseYearId(int releaseYearId) {
        return crudRepository.query(
                FIND_BY_RELEASE_YEAR_ID,
                Post.class,
                Map.of("rId", releaseYearId)
        );
    }

    /**
     * Find all Post by Body id
     *
     * @param bodyId Body id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByBodyId(int bodyId) {
        return crudRepository.query(
                FIND_BY_BODY_ID,
                Post.class,
                Map.of("bId", bodyId)
        );
    }

    /**
     * Find all Post by Colour id
     *
     * @param colourId Colour id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByColourId(int colourId) {
        return crudRepository.query(
                FIND_BY_COLOUR_ID,
                Post.class,
                Map.of("cId", colourId)
        );
    }

    /**
     * Find all Post by Transmission id
     *
     * @param transmissionId Transmission id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByTransmissionId(int transmissionId) {
        return crudRepository.query(
                FIND_BY_TRANSMISSION_ID,
                Post.class,
                Map.of("tId", transmissionId)
        );
    }

    /**
     * Find all Post by Drivetrain id
     *
     * @param drivetrainId Drivetrain id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByDrivetrainId(int drivetrainId) {
        return crudRepository.query(
                FIND_BY_DRIVETRAIN_ID,
                Post.class,
                Map.of("dId", drivetrainId)
        );
    }

    /**
     * Find all Post by EngineVolume id
     *
     * @param engineVolumeId EngineVolume id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByEngineVolumeId(int engineVolumeId) {
        return crudRepository.query(
                FIND_BY_ENGINE_VOLUME_ID,
                Post.class,
                Map.of("eId", engineVolumeId)
        );
    }

    /**
     * Find all Posts by User id
     *
     * @param userId User id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByUserId(int userId) {
        return crudRepository.query(
                FIND_POST_BY_USER_ID,
                Post.class,
                Map.of("uId", userId)
        );
    }

    /**
     * Find User's favourite Posts
     *
     * @param userId User id
     * @return List of Post
     */
    @Override
    public List<Post> findFavouritePosts(int userId) {
        return crudRepository.query(
                FIND_FAVOURITE_POSTS,
                Post.class,
                Map.of("uId", userId)
        );
    }

}
