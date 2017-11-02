package home.learning.spring.controller;

import home.learning.spring.bean.MyAnnotatedBean;
import home.learning.spring.bean.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * home.learning.spring.controller
 * Created by vorsicht on 01/11/17.
 */
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class HomeController {
    private MyBean myBean;

    private MyAnnotatedBean myAnnotatedBean;

    @Autowired
    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    @Autowired
    public void setMyAnnotatedBean(MyAnnotatedBean myAnnotatedBean) {
        this.myAnnotatedBean = myAnnotatedBean;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("MyBean hashcode=" + myBean.hashCode());
        System.out.println("MyBean annotatedHashcode=" + myAnnotatedBean.hashCode());

        Date date = new Date();

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime",formattedDate);

        return "index";
    }

}
