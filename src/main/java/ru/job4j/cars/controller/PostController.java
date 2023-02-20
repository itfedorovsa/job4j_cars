package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cars.dto.FileDto;
import ru.job4j.cars.model.*;
import ru.job4j.cars.service.*;

import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Paths;
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
public class PostController implements UserSessionController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd");

    private static final String IDENTIFIER_INSTEAD_NO_PHOTO = "mpt000.jpg";

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
    private final OwnerHistoryService ownerHistoryService;
    private final PriceHistoryService priceHistoryService;
    private final ParticipantService participantService;
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
     * @param car   Car model
     * @return lastPosts.html - posts by last day
     */
    @GetMapping("/lastPosts")
    public String lastPosts(Model model, @ModelAttribute Car car) {
        List<Post> lastPosts = postService.findPostsByLastDay();
        model.addAttribute("brands", brandService.findAllBrands());
        model.addAttribute("lastPosts", lastPosts);
        return "post/lastPosts";
    }

    /**
     * Brand selection before creating a new Post
     *
     * @param model Model
     * @return createPostBrand.html - Brand selection page
     */
    @GetMapping("/formGetBrand")
    public String formGetBrand(Model model) {
        model.addAttribute("brands", brandService.findAllBrands());
        return "post/getBrand";
    }

    /**
     * @param model   Model
     * @param car     Car model
     * @param post    Post model
     * @param brandId Brand id
     * @return addPost.html - new Post creating page form
     */
    @GetMapping("/formAddPost")
    public String formAddPost(Model model,
                              @ModelAttribute Car car,
                              @ModelAttribute Post post,
                              @RequestParam("brand.id") int brandId) {
        Brand brand = brandService.findBrandById(brandId)
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Brand by id."));
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
     * New Post creating page
     *
     * @param model       Model
     * @param car         Car model
     * @param post        Post model
     * @param file1       loaded file by user
     * @param file2       loaded file by user
     * @param file3       loaded file by user
     * @param httpSession Http Session
     * @return createPostBrand.html - Brand selection page
     */
    @PostMapping("/createPost")
    public String createPost(Model model,
                             @ModelAttribute Car car,
                             @ModelAttribute Post post,
                             @RequestParam("file1") MultipartFile file1,
                             @RequestParam("file2") MultipartFile file2,
                             @RequestParam("file3") MultipartFile file3,
                             HttpSession httpSession) {
        User user = getUser(httpSession);
        post.setUser(user);
        Owner owner = new Owner();
        owner.setUser(user);
        owner.setName(car.getOwner().getName());
        Owner addedOwner = ownerService.addOwner(owner);
        car.setOwner(addedOwner);
        car.setModel(modelService.findModelById(car.getModel().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Model by id.")));
        car.setBrand(brandService.findBrandById(car.getBrand().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Brand by id.")));
        car.setBody(bodyService.findBodyById(car.getBody().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Body by id.")));
        car.setColour(colourService.findColourById(car.getColour().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Colour by id.")));
        car.setDoorCount(doorCountService.findDoorCountById(car.getDoorCount().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the DoorCount by id.")));
        car.setDrivetrain(drivetrainService.findDrivetrainById(car.getDrivetrain().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Drivetrain by id.")));
        car.setEngineVolume(engineVolumeService.findEngineVolumeById(car.getEngineVolume().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the EngineVolume by id.")));
        car.setFuelType(fuelTypeService.findFuelTypeById(car.getFuelType().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the FuelType by id.")));
        car.setReleaseYear(releaseYearService.findReleaseYearById(car.getReleaseYear().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the ReleaseYear by id.")));
        car.setTransmission(transmissionService.findTransmissionById(car.getTransmission().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Transmission by id.")));
        carService.addCar(car);
        post.setCar(car);
        OwnerHistory ownerHistory = new OwnerHistory();
        ownerHistory.setOwnerId(addedOwner.getId());
        ownerHistory.setCarId(car.getId());
        ownerHistoryService.addOwnerHistory(ownerHistory);
        postService.addPost(post);
        httpSession.setAttribute("postId", post.getId());
        Participant participant = new Participant();
        participant.setPostId(post.getId());
        participant.setUserId(user.getId());
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setBefore(post.getPrice());
        priceHistory.setAfter(post.getPrice());
        priceHistory.setPost(post);
        priceHistoryService.addPriceHistory(priceHistory);
        participantService.addParticipant(participant);
        try {
            String filename1 = file1.getOriginalFilename();
            String filename2 = file2.getOriginalFilename();
            String filename3 = file3.getOriginalFilename();
            if ("".equals(filename1) && "".equals(filename2) && "".equals(filename3)) {
                fileService.saveFile(new FileDto(IDENTIFIER_INSTEAD_NO_PHOTO, Files.readAllBytes(
                        Paths.get("src/main/resources/static/images/coming_soon_cars.png"))), post
                );
            }
            if (!"".equals(filename1)) {
                fileService.saveFile(new FileDto(filename1, file1.getBytes()), post);
            }
            if (!"".equals(filename2)) {
                fileService.saveFile(new FileDto(filename2, file2.getBytes()), post);
            }
            if (!"".equals(filename3)) {
                fileService.saveFile(new FileDto(filename3, file3.getBytes()), post);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "error/404";
        }
        return "redirect:/formShowAddedPost";
    }

    /**
     * Post display page
     *
     * @param model       Model
     * @param postId      Post id
     * @param httpSession HTTP Session
     * @return showAddedPost.html - Added post display page
     */
    @GetMapping("/formShowAddedPost")
    public String formShowAddedPost(Model model,
                                    @SessionAttribute("postId") int postId,
                                    HttpSession httpSession) {
        Post post = postService.findPostById(postId)
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Post by id."));
        User user = getUser(httpSession);
        formatDateTime(user, post);
        model.addAttribute("post", post);
        return "post/showAddedPost";
    }

    /**
     * Post display page
     *
     * @param model       Model
     * @param postId      Post id
     * @param httpSession HTTP Session
     * @return showPost.html - Post display page
     */
    @GetMapping("/formShowPost/{postId}")
    public String formShowPost(Model model,
                               @PathVariable("postId") int postId,
                               HttpSession httpSession) {
        Post post = postService.findPostById(postId)
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Post by id."));
        User user = getUser(httpSession);
        formatDateTime(user, post);
        model.addAttribute("post", post);
        httpSession.setAttribute("postId", postId);
        return "post/showPost";
    }

    /**
     * Post display page
     *
     * @param model       Model
     * @param postId      Post id
     * @param httpSession HTTP Session
     * @return showPost.html - Post display page
     */
    @GetMapping("/formUpdatePost")
    public String formUpdatePost(Model model,
                                 @SessionAttribute("postId") int postId,
                                 HttpSession httpSession) {
        Post post = postService.findPostById(postId)
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Post by id."));
        User user = getUser(httpSession);
        formatDateTime(user, post);
        model.addAttribute("post", post);
        model.addAttribute("brands", List.of(post.getCar().getBrand()));
        model.addAttribute("models", List.of(post.getCar().getModel()));
        model.addAttribute("bodies", bodyService.findAllBodies());
        model.addAttribute("colours", colourService.findAllColours());
        model.addAttribute("doors", doorCountService.findAllDoorCounts());
        model.addAttribute("drivetrains", drivetrainService.findAllDrivetrains());
        model.addAttribute("volumes", engineVolumeService.findAllEngineVolumes());
        model.addAttribute("fuelTypes", fuelTypeService.findAllFuelTypes());
        model.addAttribute("years", releaseYearService.findAllReleaseYears());
        model.addAttribute("transmissions", transmissionService.findAllTransmissions());
        return "post/updatePost";
    }

    /**
     * Post updating page
     *
     * @param post        Post
     * @param httpSession HTTP Session
     * @return redirect to /formShowAddedPost - Added post display page
     */
    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Post post,
                             HttpSession httpSession) {
        int postId = (int) httpSession.getAttribute("postId");
        Post postById = postService.findPostById(postId)
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Post by id."));
        if (post.getPrice() != postById.getPrice()) {
            PriceHistory priceHistory = new PriceHistory();
            priceHistory.setBefore(postById.getPrice());
            priceHistory.setAfter(post.getPrice());
            priceHistory.setPost(post);
            priceHistoryService.addPriceHistory(priceHistory);
        }
        post.setUser(postById.getUser());
        post.setParticipants(postById.getParticipants());
        post.setPriceHistories(postById.getPriceHistories());
        post.setFiles(postById.getFiles());
        Car car = post.getCar();
        car.setBody(bodyService.findBodyById(car.getBody().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Body by id.")));
        car.setColour(colourService.findColourById(car.getColour().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Colour by id.")));
        car.setReleaseYear(releaseYearService.findReleaseYearById(car.getReleaseYear().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the ReleaseYear by id.")));
        car.setEngineVolume(engineVolumeService.findEngineVolumeById(car.getEngineVolume().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the EngineVolume by id.")));
        car.setDrivetrain(drivetrainService.findDrivetrainById(car.getDrivetrain().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Drivetrain by id.")));
        car.setTransmission(transmissionService.findTransmissionById(car.getTransmission().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Transmission by id.")));
        car.setFuelType(fuelTypeService.findFuelTypeById(car.getFuelType().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the FuelType by id.")));
        car.setDoorCount(doorCountService.findDoorCountById(car.getDoorCount().getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the DoorCount by id.")));
        if (!car.getOwner().getName().equals(postById.getCar().getOwner().getName())) {
            Owner owner = new Owner();
            owner.setUser(postById.getUser());
            owner.setName(car.getOwner().getName());
            ownerService.addOwner(owner);
            car.setOwner(owner);
            car.setOwners(post.getCar().getOwners());
            car.getOwners().add(owner);
            OwnerHistory ownerHistory = new OwnerHistory();
            ownerHistory.setOwnerId(owner.getId());
            ownerHistory.setCarId(car.getId());
            ownerHistoryService.addOwnerHistory(ownerHistory);
        }
        post.setCar(car);
        postService.updatePost(post);
        return "redirect:/formShowAddedPost";
    }

    /**
     * Post deletion method
     *
     * @param post Post model
     * @return lastPosts.html - posts by last day
     */
    @PostMapping("/deletePost")
    public String deleteTask(@ModelAttribute Post post) {
        postService.deletePost(post);
        return "redirect:/lastPosts";
    }

    /**
     * Marking Post as sold
     *
     * @param model Model
     * @param post  Post model
     * @return publishedPosts.html - published posts by current user
     */
    @PostMapping("/markPostAsSold")
    public String markPostAsSold(Model model, @ModelAttribute Post post) {
        Post postById = postService.findPostById(post.getId())
                .orElseThrow(() -> new NoSuchElementException("Couldn't find the Post by id."));
        postService.markPostAsSold(postById);

        model.addAttribute("post", post);
        return "redirect:/publishedPosts";
    }

    /**
     * Adding Post to favourites
     *
     * @param post        empty Post model with filled id
     * @param httpSession HTTPSession
     * @return favouritePosts.html - current user's favourite posts
     */
    @PostMapping("/addPostToFavourites")
    public String addPostToFavourites(@ModelAttribute Post post,
                                      HttpSession httpSession) {
        Participant participant = new Participant();
        participant.setUserId(getUser(httpSession).getId());
        participant.setPostId(post.getId());
        participantService.addParticipant(participant);
        return "redirect:/favouritePosts";
    }

    /**
     * Show added posts by current user
     *
     * @param model Model
     * @return publishedPosts.html - published posts by current user
     */
    @GetMapping("/publishedPosts")
    public String publishedPosts(Model model, HttpSession httpSession) {
        User user = getUser(httpSession);
        List<Post> publishedPosts = postService.findPostsByUserId(user.getId());
        model.addAttribute("publishedPosts", publishedPosts);
        return "post/publishedPosts";
    }

    /**
     * Show favourite posts by current user
     *
     * @param model       Model
     * @param httpSession HTTP Session
     * @return favouritePosts.html - favourite posts by current user
     */
    @GetMapping("/favouritePosts")
    public String favouritePosts(Model model, HttpSession httpSession) {
        User user = getUser(httpSession);
        List<Post> favouritePosts = postService.findFavouritePosts(user.getId());
        model.addAttribute("favouritePosts", favouritePosts);
        return "post/favouritePosts";
    }

    /**
     * Changes posts' LocalDateTime to formatted LDT with user's timezone
     *
     * @param user Current User
     * @param post Post
     * @return Post with changed LDT
     */
    private Post formatDateTime(User user, Post post) {
        String timezone = user.getTimezone();
        String defaultTimezone = TimeZone.getDefault().getID();

        if (timezone == null) {
            timezone = defaultTimezone;
        }
        String formatted = post.getCreated()
                .atZone(ZoneId.of(defaultTimezone))
                .withZoneSameInstant(ZoneId.of(timezone))
                .format(FORMATTER);
        post.setCreated(LocalDateTime.parse(formatted, FORMATTER));
        return post;
    }

}
