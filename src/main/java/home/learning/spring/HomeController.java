package home.learning.spring;

import home.learning.spring.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.LONG;
import static java.text.DateFormat.getDateTimeInstance;

/**
 * home.learning.spring
 * Created by vorsicht on 06/11/17.
 */
@Controller
public class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String home(Locale locale, Model model) {
        LOG.info("Welcome home the client locale is {}.", locale);
        Date date = new Date();
        DateFormat dateFormat = getDateTimeInstance(LONG, LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    private String login(@Validated User user, Model model) {
        model.addAttribute("userName", user.getUsername());
        return "user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String loginPage(Locale locale, Model model) {
        return "login";
    }
}
