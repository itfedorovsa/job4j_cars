package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.cars.model.*;
import ru.job4j.cars.service.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TimeZone;

/**
 * Post controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 22.01.23
 */
@Controller
@AllArgsConstructor
@ThreadSafe
public class PostController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd");

    private final PostService postService;
    private final CarService carService;
    private final BodyService bodyService;
    private final BrandService brandService;
    private final ColourService colourService;
    private final DoorCountService doorCountService;
    private final DrivetrainService drivetrainService;
    private final EngineVolumeService engineVolumeService;
    private final FuelTypeService fuelTypeService;
    private final ModelService modelService;
    private final ReleaseYearService releaseYearService;
    private final TransmissionService transmissionService;
    private final OwnerService ownerService;
    private final PriceHistoryService priceHistoryService;
    private final FileService fileService;

    /**
     * Add User in Model by "user" key in all Model in this controller
     *
     * @param httpSession HTTPSession
     * @return User
     */
    @ModelAttribute("user")
    public User addUserToModel(HttpSession httpSession) {
        return getUser(httpSession);
    }

    /**
     * Last posts page
     *
     * @param model Model
     * @return lastPosts.html - last posts by last day
     */
    @GetMapping("/lastPosts")
    public String lastPosts(Model model) {
        User user = (User) model.getAttribute("user");
        if (user == null) {
            throw new NoSuchElementException("User is missing");
        }
        List<Post> lastPosts = postService.findPostsByLastDay();
        getFormattedPosts(user, lastPosts);
        model.addAttribute("lastPosts", lastPosts);
        return "post/lastPosts";
    }

    /**
     * Brand selection before creating a new Post
     *
     * @param model Model
     * @return getBrand.html - Brand selection page
     */
    @GetMapping("/formGetBrand")
    public String formGetBrand(Model model) {
        model.addAttribute("brands", brandService.findAllBrands());
        return "post/getBrand";
    }

    /**
     * New Post creating page (Preparing)
     *
     * @param model   Model
     * @param car     Car
     * @param post    Post
     * @param brandId Brand id
     * @return addPost.html - new Post creating page
     */
    @GetMapping("/formAddPost")
    public String formAddPost(Model model,
                              @ModelAttribute Car car,
                              @ModelAttribute Post post,
                              @RequestParam("brand.id") int brandId) {
        Brand brand = brandService.findBrandById(brandId);
        model.addAttribute("brands", List.of(brand));
        model.addAttribute("bodies", bodyService.findAllBodies());
        model.addAttribute("colours", colourService.findAllColours());
        model.addAttribute("doors", doorCountService.findAllDoorCounts());
        model.addAttribute("drivetrains", drivetrainService.findAllDrivetrains());
        model.addAttribute("volumes", engineVolumeService.findAllEngineVolumes());
        model.addAttribute("fuelTypes", fuelTypeService.findAllFuelTypes());
        model.addAttribute("models", modelService.findAllModelsByBrandId(brandId));
        model.addAttribute("years", releaseYearService.findAllReleaseYears());
        model.addAttribute("transmissions", transmissionService.findAllTransmissions());
        return "post/addPost";
    }

    /**
     * New Post creating page (Creating)
     *
     * @param model Model
     * @param car   Car
     * @param post  Post
     * @return showPost.html - Post display/description page
     */
    @PostMapping("/createPost")
    public String createPost(Model model,
                             @ModelAttribute Car car,
                             @ModelAttribute Post post) {
        User user = (User) model.getAttribute("user");
        Owner owner = new Owner();
        owner.setUser(user);
        owner.setName(car.getOwner().getName());
        Owner addedOwner = ownerService.addOwner(owner);
        car.setOwner(addedOwner);
        car.setModel(modelService.findModelById(car.getModel().getId()));
        car.setBrand(brandService.findBrandById(car.getBrand().getId()));
        car.setBody(bodyService.findBodyById(car.getBody().getId()));
        car.setColour(colourService.findColourById(car.getColour().getId()));
        car.setDoorCount(doorCountService.findDoorCountById(car.getDoorCount().getId()));
        car.setDrivetrain(drivetrainService.findDrivetrainById(car.getDrivetrain().getId()));
        car.setEngineVolume(engineVolumeService.findEngineVolumeById(car.getEngineVolume().getId()));
        car.setFuelType(fuelTypeService.findFuelTypeById(car.getFuelType().getId()));
        car.setReleaseYear(releaseYearService.findReleaseYearById(car.getReleaseYear().getId()));
        car.setTransmission(transmissionService.findTransmissionById(car.getTransmission().getId()));
        Car addedCar = carService.addCar(car);
        post.setUser(user);
        post.setCar(addedCar);
        Post addedPost = postService.addPost(post);
        model.addAttribute("post", addedPost);
        Car carById = carService.findCarById(addedCar.getId());
        System.out.println(carById + "carByIddd");
        return "post/showPost";
    }

    /**
     * Create a user with name "Guest" if user is missing
     *
     * @param httpSession HTTPSession
     * @return new User with "Guest" name or current User
     */
    private User getUser(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Guest");
        }
        return user;
    }

    /**
     * Changes posts' LocalDateTime to formatted LDT with user's timezone
     *
     * @param user  Current User
     * @param posts List of Post
     * @return List of Post with changed LDT
     */
    private List<Post> getFormattedPosts(User user, List<Post> posts) {
        String timezone = user.getTimezone();
        String defaultTimezone = TimeZone.getDefault().getID();

        if (timezone == null) {
            timezone = defaultTimezone;
        }
        for (Post post : posts) {
            String formatted = post.getCreated()
                    .atZone(ZoneId.of(defaultTimezone))
                    .withZoneSameInstant(ZoneId.of(timezone))
                    .format(FORMATTER);
            post.setCreated(LocalDateTime.parse(formatted, FORMATTER));
        }
        return posts;
    }

}
