package pl.rozart.familytree.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by rozar_000 on 2015-04-19.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index", "message", "hello!");
    }

}
