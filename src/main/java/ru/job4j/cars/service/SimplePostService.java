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
    public void deletePost(Post post) {
        /*List<File> filesByPostId = fileService.findAllFilesByPostId(post.getId());
        for (File file : filesByPostId) {
            fileService.deleteFileById(file.getId());
        }*/
        store.deletePost(post);
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
    public List<Post> findPostsByBrandId(int brandId) {
        return store.findPostsByBrandId(brandId);
    }

    @Override
    public List<Post> findPostsByReleaseYearId(int releaseYearId) {
        return store.findPostsByReleaseYearId(releaseYearId);
    }

    @Override
    public List<Post> findPostsByBodyId(int bodyId) {
        return store.findPostsByBodyId(bodyId);
    }

    @Override
    public List<Post> findPostsByColourId(int colourId) {
        return store.findPostsByColourId(colourId);
    }

    @Override
    public List<Post> findPostsByTransmissionId(int transmissionId) {
        return store.findPostsByTransmissionId(transmissionId);
    }

    @Override
    public List<Post> findPostsByDrivetrainId(int drivetrainId) {
        return store.findPostsByDrivetrainId(drivetrainId);
    }

    @Override
    public List<Post> findPostsByEngineVolumeId(int engineVolumeId) {
        return store.findPostsByEngineVolumeId(engineVolumeId);
    }

    @Override
    public List<Post> findPostsByUserId(int userId) {
        return store.findPostsByUserId(userId);
    }

    @Override
    public List<Post> findFavouritePosts(int userId) {
        return store.findFavouritePosts(userId);
    }

    @Override
    public void markPostAsSold(Post post) {
        post.setSold(true);
        store.updatePost(post);
    }

}
