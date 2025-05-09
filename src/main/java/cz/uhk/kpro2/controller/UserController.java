package cz.uhk.kpro2.controller;

import cz.uhk.kpro2.model.User;
import cz.uhk.kpro2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users_list";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users_form";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "users_detail";
        }
        return "redirect:/users/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "users_form";
        }
        return "redirect:/users/";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/";
    }


    @GetMapping("/{id}/delete")
    public String deleteUser(Model model, @PathVariable long id) {
        User user = userService.getUser(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "users_delete";
        }
        return "redirect:/users/";
    }

    @PostMapping("/{id}/delete")
    public String deleteUserConfirm(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/users/";
    }

}
