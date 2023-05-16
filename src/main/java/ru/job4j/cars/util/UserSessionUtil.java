package ru.job4j.cars.util;

import ru.job4j.cars.model.User;

import javax.servlet.http.HttpSession;

/**
 * User util interface
 *
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 20.02.23
 */
public interface UserSessionUtil {

    /**
     * Create a user with name "Guest" if user is missing
     *
     * @param httpSession HTTPSession
     * @return new User with "Guest" name or current User
     */
    default User getUser(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Guest");
        }
        return user;
    }

}
