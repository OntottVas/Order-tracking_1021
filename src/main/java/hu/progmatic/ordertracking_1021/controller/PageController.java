package hu.progmatic.ordertracking_1021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping({"", "/", "/home"})
    public String getHome() {
        return "home";
    }

}
