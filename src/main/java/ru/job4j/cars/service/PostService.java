package ru.job4j.cars.service;

import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * Post service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface PostService {

    /**
     * Save Post in DB
     *
     * @param post Post
     * @return Optional of Post
     */
    Post addPost(Post post);

    /**
     * Update Post in DB
     *
     * @param post Post
     */
    void updatePost(Post post);

    /**
     * Delete Post
     *
     * @param post Post
     */
    void deletePost(Post post);

    /**
     * Find Post by id
     *
     * @param postId Post id
     * @return Optional of Post
     */
    Optional<Post> findPostById(int postId);

    /**
     * Find all posts
     *
     * @return List of Posts
     */
    List<Post> findAllPosts();

    /**
     * Find posts by last day
     *
     * @return List of Post
     */
    List<Post> findPostsByLastDay();

    /**
     * Find posts which have a photo
     *
     * @return List of Post
     */
    List<Post> findPostsWithPhoto();

    /**
     * Find all Post by Brand id
     *
     * @param brandId Brand id
     * @return List of Post
     */
    List<Post> findPostsByBrandId(int brandId);

    /**
     * Find all Post by ReleaseYear id
     *
     * @param releaseYearId ReleaseYear id
     * @return List of Post
     */
    List<Post> findPostsByReleaseYearId(int releaseYearId);

    /**
     * Find all Post by Body id
     *
     * @param bodyId Body id
     * @return List of Post
     */
    List<Post> findPostsByBodyId(int bodyId);

    /**
     * Find all Post by Colour id
     *
     * @param colourId Colour id
     * @return List of Post
     */
    List<Post> findPostsByColourId(int colourId);

    /**
     * Find all Post by Transmission id
     *
     * @param transmissionId Transmission id
     * @return List of Post
     */
    List<Post> findPostsByTransmissionId(int transmissionId);

    /**
     * Find all Post by Drivetrain id
     *
     * @param drivetrainId Drivetrain id
     * @return List of Post
     */
    List<Post> findPostsByDrivetrainId(int drivetrainId);

    /**
     * Find all Post by EngineVolume id
     *
     * @param engineVolumeId EngineVolume id
     * @return List of Post
     */
    List<Post> findPostsByEngineVolumeId(int engineVolumeId);

    /**
     * Find all Posts by User id
     *
     * @param userId User id
     * @return List of Post
     */
    List<Post> findPostsByUserId(int userId);

    /**
     * Find User's favourite Posts
     *
     * @param userId User id
     * @return List of Post
     */
    List<Post> findFavouritePosts(int userId);

    /**
     * Mark post as sold
     *
     * @param post Post
     */
    void markPostAsSold(Post post);

}
