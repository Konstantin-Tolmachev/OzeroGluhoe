package com.company.blog.controllers;


import com.company.blog.models.Event;
import com.company.blog.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountStaffControllers {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/StaffAccount")
    public String StaffAccount(Model model) {
        model.addAttribute("title", "Аккаунт сотрудника");
        return "StaffHTML/staffAccount";
    }



    @GetMapping("/StaffEvent")
    public String ViewEventStaff(Model model) {
        Iterable<Event> Events = eventRepository.findAll();
        model.addAttribute("Events", Events);
        return "StaffHTML/staffEvent";
    }

}
