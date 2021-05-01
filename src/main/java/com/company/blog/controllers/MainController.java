package com.company.blog.controllers;

import com.company.blog.models.Tour;
import com.company.blog.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    /* Вывод всех добавленных туров

    @GetMapping("/AllTour")
    public String addNewTour(Model model) {
        Iterable<Tour> tours = tourRepository.findAll();
        model.addAttribute("tours", tours);
        return "AdminHTML/allTour";
    } */

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


  /*  @GetMapping("/AdminHome")
    public String Test(Model model) {
        model.addAttribute("title", "Админ");
        return "adminHome";
    }

/*
    @GetMapping("/Authorization")
    public String Authorization(Model model) {
        model.addAttribute("title", "Авторизация");
        return "authorization";
    }
  @GetMapping("/authorization/registration")            // Поиграть с заглавными буквами
    public String AuthorizationRegistration(Model model){
        return "registration";
    }

   @GetMapping("/Registration")
    public String Registration(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registration";
    }
*/







    @GetMapping("/payment")
    public String payment(Model model) {
        model.addAttribute("title", "Оплата");
        return "payment";
    }


}