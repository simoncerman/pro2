package cz.uhk.kpro2.controller;

import cz.uhk.kpro2.model.BOSMember;
import cz.uhk.kpro2.service.BOSService;
import cz.uhk.kpro2.service.BOSServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bos")
public class BOSController {
    private BOSService bosService;

    @Autowired
    public BOSController(BOSService bosService) {
        this.bosService = bosService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("bosList", bosService.getAllBOSMembers());
        return "bos_list";
    }

    @GetMapping("/new")
    public String newBOS(Model model) {
        model.addAttribute("bos", new BOSMember());
        return "bos_form";
    }

    @GetMapping("/{id}")
    public String getBOS(Model model, @PathVariable long id) {
        BOSMember bos = bosService.getBOSMember(id);
        if (bos != null) {
            model.addAttribute("bos", bos);
            return "bos_detail";
        }
        return "redirect:/bos/";
    }

    @GetMapping("/{id}/edit")
    public String editBOS(Model model, @PathVariable long id) {
        BOSMember bos = bosService.getBOSMember(id);
        if (bos != null) {
            model.addAttribute("bos", bos);
            return "bos_form";
        }
        return "redirect:/bos/";
    }

    @PostMapping("/save")
    public String saveBOS(@ModelAttribute BOSMember bos) {
        bosService.saveBOSMember(bos);
        return "redirect:/bos/";
    }

    @GetMapping("/{id}/delete")
    public String deleteBOS(Model model, @PathVariable long id) {
        BOSMember bos = bosService.getBOSMember(id);
        if (bos != null) {
            model.addAttribute("bos", bos);
            return "bos_delete";
        }
        return "redirect:/bos/";
    }

    @PostMapping("/{id}/delete")
    public String deleteBOSConfirm(@PathVariable long id) {
        bosService.deleteBOSMember(id);
        return "redirect:/bos/";
    }

}