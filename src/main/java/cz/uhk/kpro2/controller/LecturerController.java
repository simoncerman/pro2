package cz.uhk.kpro2.controller;

import cz.uhk.kpro2.model.Lecturer;
import cz.uhk.kpro2.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lecturers")
public class LecturerController {

    private LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "lecturers_list";
    }

    @GetMapping("/new")
    public String newLecturer(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        return "lecturers_form";
    }

    @GetMapping("/{id}")
    public String getLecturer(Model model, @PathVariable long id) {
        Lecturer lecturer = lecturerService.getLecturer(id);
        if (lecturer != null) {
            model.addAttribute("lecturer", lecturer);
            return "lecturers_detail";
        }
        return "redirect:/lecturers/";
    }

    @GetMapping("/{id}/edit")
    public String editLecturer(Model model, @PathVariable long id) {
        Lecturer lecturer = lecturerService.getLecturer(id);
        if (lecturer != null) {
            model.addAttribute("lecturer", lecturer);
            return "lecturers_form";
        }
        return "redirect:/lecturers/";
    }

    @PostMapping("/save")
    public String saveLecturer(@ModelAttribute Lecturer lecturer) {
        lecturerService.saveLecturer(lecturer);
        return "redirect:/lecturers/";
    }


    @GetMapping("/{id}/delete")
    public String deleteLecturer(Model model, @PathVariable long id) {
        Lecturer lecturer = lecturerService.getLecturer(id);
        if (lecturer != null) {
            model.addAttribute("lecturer", lecturer);
            return "lecturers_delete";
        }
        return "redirect:/lecturers/";
    }

    @PostMapping("/{id}/delete")
    public String deleteLecturerConfirm(@PathVariable long id) {
        lecturerService.deleteLecturer(id);
        return "redirect:/lecturers/";
    }

}
