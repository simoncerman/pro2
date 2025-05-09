package cz.uhk.kpro2.controller;

import cz.uhk.kpro2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<User>();

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("users", users);
        return "users_list";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users_form";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable long id) {
        //only if user exists
        model.addAttribute("user", users.get((int)id));
        return "users_form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        users.add(user);
        return "redirect:/users/";
    }


    @GetMapping("/{id}/delete")
    public String deleteUser(Model model, @PathVariable long id) {
        model.addAttribute("user", users.get((int)id));
        return "users_delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteUserConfirm(@PathVariable long id) {
        //delete user if exists
        return "redirect:/users/";
    }

}
