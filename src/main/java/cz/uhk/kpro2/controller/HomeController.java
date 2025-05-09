package cz.uhk.kpro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping({"/home", "/"})
    public String home() {
        return "home";
    }

}
