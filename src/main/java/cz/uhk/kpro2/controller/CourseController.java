package cz.uhk.kpro2.controller;

import cz.uhk.kpro2.model.BOSMember;
import cz.uhk.kpro2.model.Course;
import cz.uhk.kpro2.model.User;
import cz.uhk.kpro2.model.FuelCell;
import cz.uhk.kpro2.service.BOSService;
import cz.uhk.kpro2.service.CourseService;
import cz.uhk.kpro2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final BOSService bosService;
    private final UserService userService;

    @Autowired
    public CourseController(CourseService courseService, BOSService bosService, UserService userService) {
        this.courseService = courseService;
        this.bosService = bosService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses_list";
    }

    @GetMapping("/new")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("bosMembers", bosService.getAllBOSMembers());
        model.addAttribute("members", userService.getAllUsers());
        return "courses_form";
    }

    @GetMapping("/{id}")
    public String getCourse(Model model, @PathVariable long id) {
        Course course = courseService.getCourse(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "courses_detail";
        }
        return "redirect:/courses/";
    }

    @GetMapping("/{id}/fuel-cells/new")
    public String redirectToFuelCellForm(@PathVariable long id) {
        return "redirect:/fuel-cells/new?courseId=" + id;
    }

    @GetMapping("/{id}/edit")
    public String editCourse(Model model, @PathVariable long id) {
        Course course = courseService.getCourse(id);
        if (course != null) {
            model.addAttribute("bosMembers", bosService.getAllBOSMembers());
            model.addAttribute("members", userService.getAllUsers());
            model.addAttribute("course", course);
            return "courses_form";
        }
        return "redirect:/courses/";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute Course course) {
        if (course.getFuelCells() != null) {
            for (FuelCell fuelCell : course.getFuelCells()) {
                fuelCell.setCourse(course); // Ensure the relationship is set
            }
        }
        courseService.saveCourse(course);
        return "redirect:/courses/";
    }

    @GetMapping("/{id}/delete")
    public String deleteCourse(Model model, @PathVariable long id) {
        Course course = courseService.getCourse(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "courses_delete";
        }
        return "redirect:/courses/";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourseConfirm(@PathVariable long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // Logic to save the user (e.g., userService.saveUser(user))
        return "redirect:/courses/login";
    }

}
