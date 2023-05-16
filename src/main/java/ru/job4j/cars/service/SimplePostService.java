package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.PostRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Post service layer
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Service
@AllArgsConstructor
@ThreadSafe
public class SimplePostService implements PostService {

    private final PostRepository store;

    /**
     * Save Post in DB
     *
     * @param post Post
     * @return Optional of Post
     */
    @Override
    public Post addPost(Post post) {
        return store.addPost(post);
    }

    /**
     * Update Post in DB
     *
     * @param post Post
     */
    @Override
    public void updatePost(Post post) {
        store.updatePost(post);
    }

    /**
     * Delete Post
     *
     * @param post Post
     */
    @Override
    public void deletePost(Post post) {
        Post postById = store.findPostById(post.getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Post by id."));
        store.deletePost(postById);
    }

    /**
     * Find Post by id
     *
     * @param postId Post id
     * @return Optional of Post
     */
    @Override
    public Optional<Post> findPostById(int postId) {
        return store.findPostById(postId);
    }

    /**
     * Find all posts
     *
     * @return List of Posts
     */
    @Override
    public List<Post> findAllPosts() {
        return store.findAllPosts();
    }

    /**
     * Find posts by last day
     *
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByLastDay() {
        return store.findPostsByLastDay();
    }

    /**
     * Find posts which have a photo
     *
     * @return List of Post
     */
    @Override
    public List<Post> findPostsWithPhoto() {
        return store.findPostsWithPhoto();
    }

    /**
     * Find all Post by Brand id
     *
     * @param brandId Brand id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByBrandId(int brandId) {
        return store.findPostsByBrandId(brandId);
    }

    /**
     * Find all Post by ReleaseYear id
     *
     * @param releaseYearId ReleaseYear id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByReleaseYearId(int releaseYearId) {
        return store.findPostsByReleaseYearId(releaseYearId);
    }

    /**
     * Find all Post by Body id
     *
     * @param bodyId Body id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByBodyId(int bodyId) {
        return store.findPostsByBodyId(bodyId);
    }

    /**
     * Find all Post by Colour id
     *
     * @param colourId Colour id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByColourId(int colourId) {
        return store.findPostsByColourId(colourId);
    }

    /**
     * Find all Post by Transmission id
     *
     * @param transmissionId Transmission id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByTransmissionId(int transmissionId) {
        return store.findPostsByTransmissionId(transmissionId);
    }

    /**
     * Find all Post by Drivetrain id
     *
     * @param drivetrainId Drivetrain id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByDrivetrainId(int drivetrainId) {
        return store.findPostsByDrivetrainId(drivetrainId);
    }

    /**
     * Find all Post by EngineVolume id
     *
     * @param engineVolumeId EngineVolume id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByEngineVolumeId(int engineVolumeId) {
        return store.findPostsByEngineVolumeId(engineVolumeId);
    }

    /**
     * Find all Posts by User id
     *
     * @param userId User id
     * @return List of Post
     */
    @Override
    public List<Post> findPostsByUserId(int userId) {
        return store.findPostsByUserId(userId);
    }

    /**
     * Find User's favourite Posts
     *
     * @param userId User id
     * @return List of Post
     */
    @Override
    public List<Post> findFavouritePosts(int userId) {
        return store.findFavouritePosts(userId);
    }

    /**
     * Mark post as sold
     *
     * @param post Post
     */
    @Override
    public void markPostAsSold(Post post) {
        post.setSold(true);
        store.updatePost(post);
    }

}
