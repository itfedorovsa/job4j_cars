package ru.job4j.cars.service;

import ru.job4j.cars.model.Post;

import java.util.List;

/**
 * Post service interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
public interface PostService {

    List<Post> findPostsByLastDay();

    List<Post> findPostsWithPhoto();

    List<Post> findPostsByBrandAndModel(String brand, String model);

}
