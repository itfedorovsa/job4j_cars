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

    Post addPost(Post post);

    void updatePost(Post post);

    void deletePost(int postId);

    Optional<Post> findPostById(int postId);

    List<Post> findPostsByLastDay();

    List<Post> findPostsWithPhoto();

    List<Post> findPostsByBrandAndModel(String brand, String model);

}
