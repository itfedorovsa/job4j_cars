package ru.job4j.cars.controller;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
public class IndexController implements UserSessionController {

    /**
     * Index page
     *
     * @param model       Model
     * @param httpSession Http Session
     * @return index.html - start page
     */
    @GetMapping("/index")
    public String index(Model model, HttpSession httpSession) {
        model.addAttribute("user", getUser(httpSession));
        return "index";
    }

}
