package com.company.blog.controllers;

import com.company.blog.models.Tour;
import com.company.blog.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private TourRepository tourRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Tour> tours = tourRepository.findAll();
        model.addAttribute("tours", tours);
        model.addAttribute("title", "С/П 'Озеро Глухое' ");
        return "home";
    }

/*RequestMapping GetMapping*/
    @GetMapping ("/Authorization")
    public String Authorization(/* Principal principal,*/ Model model) {
        model.addAttribute("title", "Авторизация");

        return  "HomeHTML/authorization"/* + principal.getName()*/;

    }

    @GetMapping("/Accommodation")
    public String Accommodation(Model model) {
        model.addAttribute("title", "Проживание");
        return "HomeHTML/accommodation";
    }

    @GetMapping("/Infrastructure")
    public String Infrastructure(Model model) {
        model.addAttribute("title", "Инфраструктура");
        return "HomeHTML/infrastructure";
    }

    @GetMapping("/Price")
    public String Price(Model model) {
        model.addAttribute("title", "Прайс");
        return "HomeHTML/price";
    }

    @GetMapping("/Сommunications")
    public String Сommunications(Model model) {
        model.addAttribute("title", "Отзывы");
        return "HomeHTML/communications";
    }

    @GetMapping("/AboutUs")
    public String AboutUs(Model model) {
        model.addAttribute("title", "О нас");
        return "HomeHTML/aboutUs";
    }

    @GetMapping("/Rules")
    public String Rules(Model model) {
        model.addAttribute("title", "Правила");
        return "HomeHTML/rules";
    }

    @GetMapping("/Comment")
    public String Comment(Model model) {
        model.addAttribute("title", "Контакты");
        return "HomeHTML/comment";
    }





    @GetMapping("/payment")
    public String payment(Model model) {
        model.addAttribute("title", "Оплата");
        return "payment";
    }

    @GetMapping("/Home")
    public String Home(Model model) {
        model.addAttribute("title", "home");
        return "home";
    }


}