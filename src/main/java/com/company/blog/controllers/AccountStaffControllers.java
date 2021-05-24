package com.company.blog.controllers;


import com.company.blog.models.Event;
import com.company.blog.models.Request;
import com.company.blog.repo.EventRepository;
import com.company.blog.repo.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class AccountStaffControllers {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RequestRepository requestRepository;


    @GetMapping("/StaffAccount")
    public String StaffAccount(Model model) {
        model.addAttribute("title", "Аккаунт рабочего КОиРЗ");
        return "StaffHTML/staffAccount";
    }

    @PostMapping("/StaffAccount")
    public String AddRequestAdmin(
            // @RequestParam("createDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createDate,
//                                  @RequestParam String korpus,
//                                  @RequestParam String room,
            @RequestParam String fromWhom,
            @RequestParam String text,
            @RequestParam String toWhom,
//                                  @RequestParam String endDay,
//                                  @RequestParam String status,
//                                  @RequestParam String fulfilled,
            Model model) {

        Request  post = new Request ("0", "0",fromWhom,text, toWhom,"","", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "");
        requestRepository.save(post);
        return "StaffHTML/staffAccount";
    }




    @GetMapping("/StaffEvent")
    public String ViewEventStaff(Model model) {
        Iterable<Event> Events = eventRepository.findAll();
        model.addAttribute("Events", Events);
        return "StaffHTML/staffEvent";
    }

}
