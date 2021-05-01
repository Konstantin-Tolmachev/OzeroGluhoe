package com.company.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountClientControllers {

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
    public String ActualInformation(Model model){
        model.addAttribute("title", "Актуальная информация");
        return "ClientHTML/actualInformation";
    }

    @GetMapping("/Events")
    public String Events(Model model){
        model.addAttribute("title", "Мероприятия");
        return "ClientHTML/events";
    }

    @GetMapping("/Request")
    public String Request(Model model){
        model.addAttribute("title", "Заявки");
        return "ClientHTML/request";
    }
/*
    @GetMapping("/HealthImprovingComplex")
    public String HealthImprovingComplex(Model model){
        model.addAttribute("title", "ЛОК");
        return "ClientHTML/healthImprovingComplex";
    }

    @GetMapping("/DiningRoom")
    public String DiningRoom(Model model){
        model.addAttribute("title", "Столовая");
        return "ClientHTML/diningRoom";
    }

    @GetMapping("/Club")
    public String Club(Model model){
        model.addAttribute("title", "Клуб");
        return "ClientHTML/club";
    }

    @GetMapping("/Rental")
    public String Rental(Model model){
        model.addAttribute("title", "Прокат");
        return "ClientHTML/rental";
    }

    @GetMapping("/Cafe")
    public String Cafe(Model model){
        model.addAttribute("title", "Кафе");
        return "ClientHTML/cafe";
    }
    @GetMapping("/Med")
    public String Med(Model model){
        model.addAttribute("title", "Мед кабинеты");
        return "ClientHTML/med";
    }

 */



}
