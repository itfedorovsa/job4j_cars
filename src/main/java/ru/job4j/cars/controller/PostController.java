package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.PostService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    /**
     * All tasks page
     *
     * @param model       Model
     * @param httpSession HTTP Session
     * @return allTasks.html - all tasks from list
     */
    @GetMapping("/lastPosts")
    public String lastPosts(Model model, HttpSession httpSession) {
        User user = getUser(httpSession);
        List<Post> lastPosts = postService.findPostsByLastDay();
        getFormattedPosts(user, lastPosts);
        model.addAttribute("lastPosts", lastPosts);
        model.addAttribute("user", user);
        return "task/allTasks";
    }

    /**
     * Gives "Guest" name if user is unregistered
     *
     * @param httpSession HTTPSession
     * @return User with "Guest" name or user with currrent name
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
     * Changes tasks' LocalDateTime to formatted LDT with user's timezone
     *
     * @param user  Current User
     * @param posts List of all, new or finished tasks
     * @return List of tasks with changed LDT
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
