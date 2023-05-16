package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.*;
import ru.job4j.cars.util.UserSessionUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Post filter controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 19.02.23
 */
@Controller
@AllArgsConstructor
@ThreadSafe
public class PostFilterController implements UserSessionUtil {

    private final PostService postService;
    private final BodyService bodyService;
    private final BrandService brandService;
    private final ColourService colourService;
    private final DrivetrainService drivetrainService;
    private final EngineVolumeService engineVolumeService;
    private final ReleaseYearService releaseYearService;
    private final TransmissionService transmissionService;

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
     * Post filters page
     *
     * @param model Model
     * @param car   Car model
     * @return postFilters.html - post filters page
     */
    @GetMapping("/postFilters")
    public String postFilters(Model model,
                              @ModelAttribute Car car) {
        model.addAttribute("brands", brandService.findAllBrands());
        model.addAttribute("bodies", bodyService.findAllBodies());
        model.addAttribute("colours", colourService.findAllColours());
        model.addAttribute("drivetrains", drivetrainService.findAllDrivetrains());
        model.addAttribute("volumes", engineVolumeService.findAllEngineVolumes());
        model.addAttribute("years", releaseYearService.findAllReleaseYears());
        model.addAttribute("transmissions", transmissionService.findAllTransmissions());
        return "post/postFilters";
    }

    /**
     * Posts Brand-filtered page
     *
     * @param model Model
     * @param car   Car model
     * @return filteredPosts.html - page with posts Brand-filtered
     */
    @GetMapping("/filterByBrand")
    public String filterByBrand(Model model,
                                @ModelAttribute Car car) {
        return loadFilteredPostsToModel(model, postService.findPostsByBrandId(car.getBrand().getId()));
    }

    /**
     * Posts ReleaseYear-filtered page
     *
     * @param model Model
     * @param car   Car model
     * @return filteredPosts.html - page with posts ReleaseYear-filtered
     */
    @GetMapping("/filterByReleaseYear")
    public String filterByReleaseYear(Model model,
                                      @ModelAttribute Car car) {
        return loadFilteredPostsToModel(model, postService.findPostsByReleaseYearId(car.getReleaseYear().getId()));
    }

    /**
     * Posts Body-filtered page
     *
     * @param model Model
     * @param car   Car model
     * @return filteredPosts.html - page with posts Body-filtered
     */
    @GetMapping("/filterByBody")
    public String filterByBody(Model model,
                               @ModelAttribute Car car) {
        return loadFilteredPostsToModel(model, postService.findPostsByBodyId(car.getBody().getId()));
    }

    /**
     * Posts Colour-filtered page
     *
     * @param model Model
     * @param car   Car model
     * @return filteredPosts.html - page with posts Colour-filtered
     */
    @GetMapping("/filterByColour")
    public String filterByColour(Model model,
                                 @ModelAttribute Car car) {
        return loadFilteredPostsToModel(model, postService.findPostsByColourId(car.getColour().getId()));
    }

    /**
     * Posts Transmission-filtered page
     *
     * @param model Model
     * @param car   Car model
     * @return filteredPosts.html - page with posts Transmission-filtered
     */
    @GetMapping("/filterByTransmission")
    public String filterByTransmission(Model model,
                                       @ModelAttribute Car car) {
        return loadFilteredPostsToModel(model, postService.findPostsByTransmissionId(car.getTransmission().getId()));
    }

    /**
     * Posts Drivetrain-filtered page
     *
     * @param model Model
     * @param car   Car model
     * @return filteredPosts.html - page with posts Drivetrain-filtered
     */
    @GetMapping("/filterByDrivetrain")
    public String filterByDrivetrain(Model model,
                                     @ModelAttribute Car car) {
        return loadFilteredPostsToModel(model, postService.findPostsByDrivetrainId(car.getDrivetrain().getId()));
    }

    /**
     * Posts EngineVolume-filtered page
     *
     * @param model Model
     * @param car   Car model
     * @return filteredPosts.html - page with posts EngineVolume-filtered
     */
    @GetMapping("/filterByEngineVolume")
    public String filterByEngineVolume(Model model,
                                       @ModelAttribute Car car) {
        return loadFilteredPostsToModel(model, postService.findPostsByEngineVolumeId(car.getEngineVolume().getId()));
    }

    /**
     * Load posts filtered by user's choice to model
     *
     * @param model         Model
     * @param filteredPosts List of posts from db
     * @return filteredPosts.html - page with posts filtered by user's choice
     */
    private String loadFilteredPostsToModel(Model model, List<Post> filteredPosts) {
        model.addAttribute("filteredPosts", filteredPosts);
        return "post/filteredPosts";
    }

}
