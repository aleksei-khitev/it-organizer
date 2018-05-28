package ru.akhitev.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.akhitev.organizer.logic.business.service.ProjectService;
import ru.akhitev.organizer.logic.business.service.TicketService;

@Controller
public class MainController {
    public static final int NAME_SIZE = 35;
    @Autowired
    ProjectService projectService;

    @Autowired
    TicketService ticketService;

    @RequestMapping("/")
    public String project(@RequestParam(value="name", required=false, defaultValue="AirTransat") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("projects", projectService.giveProjectsForList(NAME_SIZE));
        model.addAttribute("tickets", ticketService.giveTicketsForListByProject(NAME_SIZE));
        return "main";
    }
}
