package com.company.blog.controllers;

import com.company.blog.models.Booking;
import com.company.blog.models.KorpusOneRooms;
import com.company.blog.models.KorpusTwoRooms;

import com.company.blog.repo.BookingRepository;
import com.company.blog.repo.KorpusOneRoomsRepository;
import com.company.blog.repo.KorpusTwoRoomsRepository;
import com.company.blog.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private KorpusOneRoomsRepository korpusOneRoomsRepository;
    @Autowired
    private KorpusTwoRoomsRepository korpusTwoRoomsRepository;
    @Autowired
    private BookingRepository bookingRepository;



    @GetMapping("/")
    public String home(Model model) {
//        Iterable<Tour> tours = tourRepository.findAll();
//        model.addAttribute("tours", tours);
        Iterable<KorpusOneRooms> Rooms_1k = korpusOneRoomsRepository.findAll();
        model.addAttribute("Rooms_1k", Rooms_1k);

        Iterable<KorpusTwoRooms> Rooms_2k = korpusTwoRoomsRepository.findAll();
        model.addAttribute("Rooms_2k", Rooms_2k);

        model.addAttribute("title", "С/П 'Озеро Глухое' ");
        return "home";
    }

    @PostMapping("/") //AllClients; home; / можо попробовать
    public String Payment( @RequestParam String fname,
                           @RequestParam String lname,
                           @RequestParam String pname,
                           @RequestParam String phone,
                           @RequestParam String dateIn,
                           @RequestParam String dateOut,
                           @RequestParam String korpus,
                           @RequestParam String myRoomId,
                           Model model) {
        Booking post = new Booking (fname, lname, pname, phone, dateIn, dateOut, korpus, myRoomId);
        bookingRepository.save(post);
        return "home";
//        return "redirect:/";
    }



    @PostMapping("BookingFilter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Booking> bookings;

        if (filter !=null && !filter.isEmpty()){
            bookings = bookingRepository.findByFname(filter);
        } else {
            bookings = bookingRepository.findAll();
        }

        model.addAttribute("bookings", bookings);
        return "AdminHTML/allClients";
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





//    @GetMapping("/payment")
//    public String payment(Model model) {
//        model.addAttribute("title", "Оплата");
//        return "payment";
//    }
//
//    @GetMapping("/")
//    public String Home(Model model) {
//        model.addAttribute("title", "home");
//        return "home";
//    }


}