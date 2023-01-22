package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.cars.model.User;

import javax.servlet.http.HttpSession;

/**
 * Index controller
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 15.01.23
 */
@Controller
@AllArgsConstructor
@ThreadSafe
public class IndexController {

    /**
     * Index page
     *
     * @param model       Model
     * @param httpSession Http Session
     * @return index.html - start page
     */
    @GetMapping("/index")
    public String index(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Guest");
        }
        model.addAttribute("user", user);
        return "index";
    }
}
