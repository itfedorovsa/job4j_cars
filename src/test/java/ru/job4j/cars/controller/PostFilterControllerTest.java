package ru.job4j.cars.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import ru.job4j.cars.model.*;
import ru.job4j.cars.service.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * PostFilter controller test class
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 21.02.23
 */
public class PostFilterControllerTest {

    private PostService postService;
    private BodyService bodyService;
    private BrandService brandService;
    private ColourService colourService;
    private DrivetrainService drivetrainService;
    private EngineVolumeService engineVolumeService;
    private ReleaseYearService releaseYearService;
    private TransmissionService transmissionService;
    private PostFilterController postFilterController;

    @BeforeEach
    public void initServices() {
        postService = mock(PostService.class);
        bodyService = mock(BodyService.class);
        brandService = mock(BrandService.class);
        colourService = mock(ColourService.class);
        drivetrainService = mock(DrivetrainService.class);
        engineVolumeService = mock(EngineVolumeService.class);
        releaseYearService = mock(ReleaseYearService.class);
        transmissionService = mock(TransmissionService.class);
        postFilterController = new PostFilterController(postService, bodyService, brandService, colourService,
                drivetrainService, engineVolumeService, releaseYearService, transmissionService);
    }

    /**
     * Test post filters page
     */
    @Test
    public void whenGetPostFiltersPage() {
        List<Brand> expectedBrands = List.of(new Brand(1, "name1"), new Brand(2, "name2"));
        List<Body> expectedBodies = List.of(new Body(1, "name1"), new Body(2, "name2"));
        List<Colour> expectedColours = List.of(new Colour(1, "name1"), new Colour(2, "name2"));
        List<Drivetrain> expectedDrivetrains = List.of(
                new Drivetrain(1, "name1"), new Drivetrain(2, "name2"));
        List<EngineVolume> expectedEngineVolumes = List.of(
                new EngineVolume(1, 1.0), new EngineVolume(2, 2.0));
        List<ReleaseYear> expectedReleaseYears = List.of(
                new ReleaseYear(1, 1991), new ReleaseYear(2, 1992));
        List<Transmission> expectedTransmissions = List.of(
                new Transmission(1, "name1"), new Transmission(2, "name2"));
        when(brandService.findAllBrands()).thenReturn(expectedBrands);
        when(bodyService.findAllBodies()).thenReturn(expectedBodies);
        when(colourService.findAllColours()).thenReturn(expectedColours);
        when(drivetrainService.findAllDrivetrains()).thenReturn(expectedDrivetrains);
        when(engineVolumeService.findAllEngineVolumes()).thenReturn(expectedEngineVolumes);
        when(releaseYearService.findAllReleaseYears()).thenReturn(expectedReleaseYears);
        when(transmissionService.findAllTransmissions()).thenReturn(expectedTransmissions);

        Model model = new ConcurrentModel();
        String view = postFilterController.postFilters(model, new Car());
        Object actualBrands = model.getAttribute("brands");
        Object actualBodies = model.getAttribute("bodies");
        Object actualColours = model.getAttribute("colours");
        Object actualDrivetrains = model.getAttribute("drivetrains");
        Object actualEngineVolumes = model.getAttribute("volumes");
        Object actualReleaseYears = model.getAttribute("years");
        Object actualTransmissions = model.getAttribute("transmissions");
        assertThat(view).isEqualTo("post/postFilters");
        assertThat(actualBrands).isEqualTo(expectedBrands);
        assertThat(actualBodies).isEqualTo(expectedBodies);
        assertThat(actualColours).isEqualTo(expectedColours);
        assertThat(actualDrivetrains).isEqualTo(expectedDrivetrains);
        assertThat(actualEngineVolumes).isEqualTo(expectedEngineVolumes);
        assertThat(actualReleaseYears).isEqualTo(expectedReleaseYears);
        assertThat(actualTransmissions).isEqualTo(expectedTransmissions);
    }

    /**
     * Test filter posts by brand
     */
    @Test
    public void whenFilterByBrandThenGetPageWithFilteredPosts() {
        Post post1 = new Post();
        Car car1 = new Car();
        car1.setBrand(new Brand(1, "name1"));
        post1.setCar(car1);
        Post post2 = new Post();
        Car car2 = new Car();
        car2.setBrand(new Brand(1, "name1"));
        post2.setCar(car2);
        List<Post> expectedPosts = List.of(post1, post2);
        when(postService.findPostsByBrandId(1)).thenReturn(expectedPosts);

        Model model = new ConcurrentModel();
        String view = postFilterController.filterByBrand(model, car1);
        Object actualPosts = model.getAttribute("filteredPosts");

        assertThat(view).isEqualTo("post/filteredPosts");
        assertThat(actualPosts).isEqualTo(expectedPosts);
    }

    /**
     * Test filter posts by year of release
     */
    @Test
    public void whenFilterByReleaseYearThenGetPageWithFilteredPosts() {
        Post post1 = new Post();
        Car car1 = new Car();
        car1.setReleaseYear(new ReleaseYear(1, 2023));
        post1.setCar(car1);
        Post post2 = new Post();
        Car car2 = new Car();
        car2.setReleaseYear(new ReleaseYear(1, 2023));
        post2.setCar(car2);
        List<Post> expectedPosts = List.of(post1, post2);
        when(postService.findPostsByReleaseYearId(1)).thenReturn(expectedPosts);

        Model model = new ConcurrentModel();
        String view = postFilterController.filterByReleaseYear(model, car1);
        Object actualPosts = model.getAttribute("filteredPosts");

        assertThat(view).isEqualTo("post/filteredPosts");
        assertThat(actualPosts).isEqualTo(expectedPosts);
    }

    /**
     * Test filter posts by body
     */
    @Test
    public void whenFilterByBodyThenGetPageWithFilteredPosts() {
        Post post1 = new Post();
        Car car1 = new Car();
        car1.setBody(new Body(1, "name1"));
        post1.setCar(car1);
        Post post2 = new Post();
        Car car2 = new Car();
        car2.setBody(new Body(1, "name1"));
        post2.setCar(car2);
        List<Post> expectedPosts = List.of(post1, post2);
        when(postService.findPostsByBodyId(1)).thenReturn(expectedPosts);

        Model model = new ConcurrentModel();
        String view = postFilterController.filterByBody(model, car1);
        Object actualPosts = model.getAttribute("filteredPosts");

        assertThat(view).isEqualTo("post/filteredPosts");
        assertThat(actualPosts).isEqualTo(expectedPosts);
    }

    /**
     * Test filter posts by colour
     */
    @Test
    public void whenFilterByColourThenGetPageWithFilteredPosts() {
        Post post1 = new Post();
        Car car1 = new Car();
        car1.setColour(new Colour(1, "name1"));
        post1.setCar(car1);
        Post post2 = new Post();
        Car car2 = new Car();
        car2.setColour(new Colour(1, "name1"));
        post2.setCar(car2);
        List<Post> expectedPosts = List.of(post1, post2);
        when(postService.findPostsByColourId(1)).thenReturn(expectedPosts);

        Model model = new ConcurrentModel();
        String view = postFilterController.filterByColour(model, car1);
        Object actualPosts = model.getAttribute("filteredPosts");

        assertThat(view).isEqualTo("post/filteredPosts");
        assertThat(actualPosts).isEqualTo(expectedPosts);
    }

    /**
     * Test filter posts by transmission
     */
    @Test
    public void whenFilterByTransmissionThenGetPageWithFilteredPosts() {
        Post post1 = new Post();
        Car car1 = new Car();
        car1.setTransmission(new Transmission(1, "name1"));
        post1.setCar(car1);
        Post post2 = new Post();
        Car car2 = new Car();
        car2.setTransmission(new Transmission(1, "name1"));
        post2.setCar(car2);
        List<Post> expectedPosts = List.of(post1, post2);
        when(postService.findPostsByTransmissionId(1)).thenReturn(expectedPosts);

        Model model = new ConcurrentModel();
        String view = postFilterController.filterByTransmission(model, car1);
        Object actualPosts = model.getAttribute("filteredPosts");

        assertThat(view).isEqualTo("post/filteredPosts");
        assertThat(actualPosts).isEqualTo(expectedPosts);
    }

    /**
     * Test filter posts by drivetrain
     */
    @Test
    public void whenFilterByDrivetrainThenGetPageWithFilteredPosts() {
        Post post1 = new Post();
        Car car1 = new Car();
        car1.setDrivetrain(new Drivetrain(1, "name1"));
        post1.setCar(car1);
        Post post2 = new Post();
        Car car2 = new Car();
        car2.setDrivetrain(new Drivetrain(1, "name1"));
        post2.setCar(car2);
        List<Post> expectedPosts = List.of(post1, post2);
        when(postService.findPostsByDrivetrainId(1)).thenReturn(expectedPosts);

        Model model = new ConcurrentModel();
        String view = postFilterController.filterByDrivetrain(model, car1);
        Object actualPosts = model.getAttribute("filteredPosts");

        assertThat(view).isEqualTo("post/filteredPosts");
        assertThat(actualPosts).isEqualTo(expectedPosts);
    }

    /**
     * Test filter posts by engine capacity
     */
    @Test
    public void whenFilterByEngineVolumeThenGetPageWithFilteredPosts() {
        Post post1 = new Post();
        Car car1 = new Car();
        car1.setEngineVolume(new EngineVolume(1, 2.0));
        post1.setCar(car1);
        Post post2 = new Post();
        Car car2 = new Car();
        car2.setEngineVolume(new EngineVolume(1, 2.0));
        post2.setCar(car2);
        List<Post> expectedPosts = List.of(post1, post2);
        when(postService.findPostsByEngineVolumeId(1)).thenReturn(expectedPosts);

        Model model = new ConcurrentModel();
        String view = postFilterController.filterByEngineVolume(model, car1);
        Object actualPosts = model.getAttribute("filteredPosts");

        assertThat(view).isEqualTo("post/filteredPosts");
        assertThat(actualPosts).isEqualTo(expectedPosts);
    }

}