package cz.uhk.kpro2.controller;

import cz.uhk.kpro2.model.Course;
import cz.uhk.kpro2.model.FuelCell;
import cz.uhk.kpro2.service.CourseService;
import cz.uhk.kpro2.service.FuelCellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fuel-cells")
public class FuelCellController {

    private final FuelCellService fuelCellService;
    private final CourseService courseService;

    @Autowired
    public FuelCellController(FuelCellService fuelCellService, CourseService courseService) {
        this.fuelCellService = fuelCellService;
        this.courseService = courseService;
    }

    @GetMapping("/new")
    public String newFuelCell(@RequestParam long courseId, Model model) {
        Course course = courseService.getCourse(courseId);
        if (course != null) {
            FuelCell fuelCell = new FuelCell();
            fuelCell.setCourse(course);
            model.addAttribute("fuelCell", fuelCell);
            return "fuel_cells_form";
        }
        return "redirect:/courses/";
    }

    @PostMapping("/save")
    public String saveFuelCell(@ModelAttribute FuelCell fuelCell) {
        fuelCellService.saveFuelCell(fuelCell);
        return "redirect:/courses/" + fuelCell.getCourse().getId();
    }

    @GetMapping("/{id}/edit")
    public String editFuelCell(@PathVariable long id, Model model) {
        FuelCell fuelCell = fuelCellService.getFuelCell(id);
        if (fuelCell != null) {
            model.addAttribute("fuelCell", fuelCell);
            return "fuel_cells_form";
        }
        return "redirect:/courses/";
    }

    @GetMapping("/{id}/delete")
    public String deleteFuelCell(@PathVariable long id, Model model) {
        FuelCell fuelCell = fuelCellService.getFuelCell(id);
        if (fuelCell != null) {
            model.addAttribute("fuelCell", fuelCell);
            return "fuel_cells_delete";
        }
        return "redirect:/courses/";
    }

    @PostMapping("/{id}/delete-confirm")
    public String deleteFuelCellConfirm(@PathVariable long id) {
        FuelCell fuelCell = fuelCellService.getFuelCell(id);
        if (fuelCell != null) {
            long courseId = fuelCell.getCourse().getId();
            fuelCellService.deleteFuelCell(id);
            return "redirect:/courses/" + courseId + "/fuel-cells";
        }
        return "redirect:/courses/";
    }

    @PostMapping("/{id}/update")
    public void updateFuelCell(@PathVariable long id, @RequestBody FuelCell updatedFuelCell) {
        FuelCell fuelCell = fuelCellService.getFuelCell(id);
        if (fuelCell != null) {
            fuelCell.setHeight(updatedFuelCell.getHeight());
            fuelCell.setWidth(updatedFuelCell.getWidth());
            fuelCell.setQuality(updatedFuelCell.getQuality());
            fuelCell.setHoleOffcenter(updatedFuelCell.getHoleOffcenter());
            fuelCellService.saveFuelCell(fuelCell);
        }
    }

    @PostMapping("/{id}/delete")
    public void deleteFuelCell(@PathVariable long id) {
        fuelCellService.deleteFuelCell(id);
    }

    @GetMapping("/list")
    public String listFuelCells(@RequestParam long courseId, Model model) {
        Course course = courseService.getCourse(courseId);
        if (course != null) {
            model.addAttribute("course", course);
            model.addAttribute("fuelCells", course.getFuelCells());
            return "fuel_cells_list";
        }
        return "redirect:/courses/";
    }
}
