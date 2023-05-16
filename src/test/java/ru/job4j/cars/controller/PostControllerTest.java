package ru.job4j.cars.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cars.model.*;
import ru.job4j.cars.service.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class PostControllerTest {

    private PostService postService;
    private CarService carService;
    private BodyService bodyService;
    private BrandService brandService;
    private ColourService colourService;
    private DoorCountService doorCountService;
    private DrivetrainService drivetrainService;
    private EngineVolumeService engineVolumeService;
    private FuelTypeService fuelTypeService;
    private ModelService modelService;
    private ReleaseYearService releaseYearService;
    private TransmissionService transmissionService;
    private OwnerService ownerService;
    private OwnerHistoryService ownerHistoryService;
    private PriceHistoryService priceHistoryService;
    private ParticipantService participantService;
    private FileService fileService;
    private PostController postController;
    private MultipartFile testFile;
    private HttpSession httpSession;

    /*@BeforeEach
    public void initServices() {
        postService = mock(PostService.class);
        carService = mock(CarService.class);
        bodyService = mock(BodyService.class);
        brandService = mock(BrandService.class);
        colourService = mock(ColourService.class);
        doorCountService = mock(DoorCountService.class);
        drivetrainService = mock(DrivetrainService.class);
        engineVolumeService = mock(EngineVolumeService.class);
        fuelTypeService = mock(FuelTypeService.class);
        modelService = mock(ModelService.class);
        releaseYearService = mock(ReleaseYearService.class);
        transmissionService = mock(TransmissionService.class);
        ownerService = mock(OwnerService.class);
        ownerHistoryService = mock(OwnerHistoryService.class);
        priceHistoryService = mock(PriceHistoryService.class);
        participantService = mock(ParticipantService.class);
        fileService = mock(FileService.class);
        postController = new PostController(postService, carService, bodyService, brandService, colourService, doorCountService,
                drivetrainService, engineVolumeService, fuelTypeService, modelService, releaseYearService, transmissionService,
                ownerService, ownerHistoryService, priceHistoryService, participantService, fileService);
        testFile = new MockMultipartFile("testFile.img", new byte[]{1, 2, 3});
        httpSession = mock(HttpSession.class);
    }*/

    @Test
    void whenRequestLastPostsPageThenGetPageWithLastPosts() {
        Post post1 = new Post(
                1,
                "desc1",
                LocalDateTime.now().withSecond(0).withNano(0),
                new User(1),
                Set.of(new PriceHistory(1)),
                Set.of(new User(1)),
                new Car(1),
                100,
                List.of(),
                true
        );
    }

    @Test
    void whenAddPostWithoutFileThenSameDataAndRedirectToShowPostPage() {
        Car car = new Car(1,
                new Brand(1, "brand1"),
                new ru.job4j.cars.model.Model(1, "model1", new Brand(1, "brand1")),
                "vin1",
                100,
                new Body(1, "body1"),
                new Colour(1, "colour1"),
                new ReleaseYear(1, 2000),
                new EngineVolume(1, 2.0),
                Set.of(new Owner(1)),
                new Owner(1, "name1", new User(1), Set.of(new Car(1))),
                new Drivetrain(1, "drivetrain1"),
                new Transmission(1, "transmission1"),
                new FuelType(1, "fuelType1"),
                new DoorCount(1, "doorCount1")
        );
        Post post = new Post(
                1,
                "desc1",
                LocalDateTime.now().withSecond(0).withNano(0),
                new User(1),
                Set.of(new PriceHistory(1)),
                Set.of(new User(1)),
                car,
                100,
                List.of(),
                true
        );
        var postArgumentCaptor = ArgumentCaptor.forClass(Post.class);
        var carArgumentCaptor = ArgumentCaptor.forClass(Post.class);
        when(postService.addPost(postArgumentCaptor.capture())).thenReturn(post);

        Model model = new ConcurrentModel();
        String view = postController.createPost(model, car, post, null, null, null, httpSession);
        Post actualPost = postArgumentCaptor.getValue();

        assertThat(view).isEqualTo("redirect:/formShowAddedPost");
        assertThat(actualPost).isEqualTo(post);
    }

    /*@Test
    void whenAddPostWithFileThenSameDataAndRedirectToShowPostPage() throws Exception {
        Post post = new Post(
                1,
                "desc1",
                LocalDateTime.now().withSecond(0).withNano(0),
                new User(1),
                Set.of(new PriceHistory(1)),
                Set.of(new User(1)),
                new Car(1),
                100,
                List.of(),
                true
        );
        FileDto fileDto = new FileDto(testFile.getOriginalFilename(), testFile.getBytes());
        var postArgumentCaptor = ArgumentCaptor.forClass(Post.class);
        var fileDtoArgumentCaptor = ArgumentCaptor.forClass(FileDto.class);
        when(postService.addPost(postArgumentCaptor.capture(), fileDtoArgumentCaptor.capture())).thenReturn(post);

        Model model = new ConcurrentModel();
        String view = postController.createPost(model, new Car(), post, testFile, null, null, httpSession);
        Post actualPost = postArgumentCaptor.getValue();
        FileDto actualFileDto = fileDtoArgumentCaptor.getValue();

        assertThat(view).isEqualTo("redirect:/formShowAddedPost");
        assertThat(actualPost).isEqualTo(post);
        assertThat(fileDto).usingRecursiveComparison().isEqualTo(actualFileDto);
    }*/

}