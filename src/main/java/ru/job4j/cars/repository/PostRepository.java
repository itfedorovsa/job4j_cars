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

    Optional<Post> addPost(Post post);

    void updatePost(Post post);

    void deletePost(int postId);

    Optional<Post> findPostById(int postId);

    List<Post> findPostsByLastDay();

    List<Post> findPostsWithPhoto();

    List<Post> findPostsByBrandAndModel(String brand, String model);

}
