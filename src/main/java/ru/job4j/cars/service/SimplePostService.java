package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.PostRepository;

import java.util.List;

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

    @Override
    public List<Post> findPostsByLastDay() {
        return store.findPostsByLastDay();
    }

    @Override
    public List<Post> findPostsWithPhoto() {
        return store.findPostsWithPhoto();
    }

    @Override
    public List<Post> findPostsByBrandAndModel(String brand, String model) {
        return store.findPostsByBrandAndModel(brand, model);
    }
}
