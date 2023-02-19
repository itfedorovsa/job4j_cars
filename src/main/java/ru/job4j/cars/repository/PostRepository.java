package ru.job4j.cars.repository;

import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * Post repository interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 10.01.23
 */
public interface PostRepository {

    Post addPost(Post post);

    void updatePost(Post post);

    void deletePost(Post post);

    Optional<Post> findPostById(int postId);

    List<Post> findPostsByLastDay();

    List<Post> findPostsWithPhoto();

    List<Post> findPostsByBrandId(int brandId);

    List<Post> findPostsByReleaseYearId(int releaseYearId);

    List<Post> findPostsByBodyId(int bodyId);

    List<Post> findPostsByColourId(int colourId);

    List<Post> findPostsByTransmissionId(int transmissionId);

    List<Post> findPostsByDrivetrainId(int drivetrainId);

    List<Post> findPostsByEngineVolumeId(int engineVolumeId);

    List<Post> findPostsByUserId(int userId);

    List<Post> findFavouritePosts(int userId);

}
