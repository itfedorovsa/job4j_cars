package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.PostRepository;

import java.util.List;
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

    private final FileService fileService;

    @Override
    public Post addPost(Post post) {
        return store.addPost(post);
    }

    @Override
    public void updatePost(Post post) {
        store.updatePost(post);
    }

    @Override
    public void deletePost(int postId) {
        store.deletePost(postId);
    }

    @Override
    public Optional<Post> findPostById(int postId) {
        return store.findPostById(postId);
    }

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
