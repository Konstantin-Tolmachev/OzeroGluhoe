/*  package com.company.blog.controllers;


import com.company.blog.models.Registration;
import com.company.blog.repo.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationsController {

    @Autowired
    private RegistrationRepository registrationRepository;



    @GetMapping("/Authorization")
    public String Authorization(Model model) {
        model.addAttribute("title", "Авторизация");
      return "HomeHTML/authorization";

    }
*/

/*
    @PostMapping("/Authorization")
    public String authorization1   ( @RequestParam String login,
                                     @RequestParam String password,
                                     Model model) {
        Authorization post = new Authorization(login, password);
        registrationRepository.save(post);
        return "HomeHTML/registration";
    }







    @GetMapping("/Registration")
    public String Registration(Model model) {
        model.addAttribute("title", "Регистрация");
        return "HomeHTML/registration";
    }


    @PostMapping("/Registration")
    public String test   ( @RequestParam String login,
                           @RequestParam String password,
                          // @RequestParam String passwordConfirm,
                           Model model) {
        Registration post = new Registration (login, password);
        registrationRepository.save(post);
        return "HomeHTML/registration";
    }







}

        */