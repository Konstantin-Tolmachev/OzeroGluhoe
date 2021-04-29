 package com.company.blog.controllers;


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


    /* Выводтаблицы Booking

    @GetMapping("/AllRegistrations")
    public String allRegistrations(Model model) {
        Iterable<Registration> registrations = registrationRepository.findAll();
        model.addAttribute("registrations", registrations);
        return "allRegistrations";
    }
    */

    @GetMapping("/Authorization")
    public String Authorization(Model model) {
        model.addAttribute("title", "Авторизация");
        return "authorization";
    }

    /*

    @GetMapping("/authorization/registration")            // Поиграть с заглавными буквами
    public String AuthorizationRegistration(Model model){
        return "registration";
    }
*/

    /*!!!*/
    @GetMapping("/Registration")
    public String Registration(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration";
    }


    @PostMapping("/Registration")
    public String test   ( @RequestParam String login,
                           @RequestParam String password,
                          // @RequestParam String passwordConfirm,
                           Model model) {
        Registration post = new Registration (login, password/*, passwordConfirm*/);
        registrationRepository.save(post);
        return "registration";
    }





}

