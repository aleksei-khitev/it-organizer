package ru.akhitev.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.akhitev.organizer.logic.business.service.ProjectService;

@Controller
public class MainController {
    public static final int NAME_SIZE = 20;
    @Autowired
    ProjectService service;

    @RequestMapping("/")
    public String project(@RequestParam(value="name", required=false, defaultValue="AirTransat") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("projects", service.giveProjectsForList(NAME_SIZE));
        return "main";
    }
}
