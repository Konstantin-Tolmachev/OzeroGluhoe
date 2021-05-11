package com.company.blog.controllers;


import com.company.blog.models.*;
import com.company.blog.repo.ActualInformationRepository;
import com.company.blog.repo.EventRepository;
import com.company.blog.repo.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class AccountClientControllers {
    @Autowired
    private ActualInformationRepository actualInformationRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RequestRepository requestRepository;

  @GetMapping("/MyAccount")
      public String MyAccount(Model model){
      model.addAttribute("title", "Мой аккаунт");
              return "ClientHTML/myAccount";
  }

    @GetMapping("/TimeTable")
    public String TimeTable(Model model){
        model.addAttribute("title", "Расписание");
        return "ClientHTML/timeTable";
    }



    @GetMapping("/ActualInformation")
    public String ViewActualInformation(Model model) {
        Iterable<ActualInformation> ActualInformations = actualInformationRepository.findAll();
        model.addAttribute("ActualInformations", ActualInformations);
        return "ClientHTML/actualInformation";
    }


    @GetMapping("/Event")
    public String ViewEvent(Model model) {
        Iterable<Event> Events = eventRepository.findAll();
        model.addAttribute("Events", Events);
        return "ClientHTML/event";
    }

    @GetMapping("/Request")
    public String Request(Model model){
        model.addAttribute("title", "Заявки");
        return "ClientHTML/request";
    }

    /*Создать первую часть БД*/

    @PostMapping("/Request")
    public String Request( @RequestParam("date") Timestamp createDate,
                           @RequestParam String korpus,
                           @RequestParam String myRoomId,
                           @RequestParam String textRequest,
                           @RequestParam String toWhom,
                           @RequestParam Timestamp createEndDate,
                           @RequestParam String fulfilled,
                           Model model) {
        Request post = new Request (createDate,korpus, myRoomId, textRequest,
                                    toWhom,createEndDate,fulfilled);
        requestRepository.save(post);
        return "request";
    }



}
