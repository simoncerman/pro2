package cz.uhk.kpro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }

    @GetMapping("/test")
    public String test(Model model) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Milk");
        list.add("Cheese");
        list.add("Ham");
        list.add("Pineapple");
        model.addAttribute("list", list);
        model.addAttribute("title", "Test");
        return "home";
    }

}
