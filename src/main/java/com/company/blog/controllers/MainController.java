package com.company.blog.controllers;

import com.company.blog.models.*;

import com.company.blog.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private CommentRepository commentRepository;



    @GetMapping("/")
    public String home(Model model) {
//        Iterable<Tour> tours = tourRepository.findAll();
//        model.addAttribute("tours", tours);
        Iterable<KorpusOneRooms> Rooms_1k = korpusOneRoomsRepository.findByFreeOneKorpus1();
        model.addAttribute("Rooms_1k", Rooms_1k);

        Iterable<KorpusTwoRooms> Rooms_2k = korpusTwoRoomsRepository.findByFreeTwoKorpus2();
        model.addAttribute("Rooms_2k", Rooms_2k);

        model.addAttribute("title", "С/П 'Озеро Глухое' ");
        return "home";
    }

    @PostMapping("/Payment") //AllClients; home; / можо попробовать
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
        //      return "home";
        return "redirect:/Payment";
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
        Iterable<Price> prices = priceRepository.findByPriceOne();
        model.addAttribute("prices", prices);

        Iterable<Price> pricess = priceRepository.findByPriceTwo();
        model.addAttribute("pricess", pricess);

        model.addAttribute("title", "Номерной фонд");
        return "HomeHTML/accommodation";
    }

//    @GetMapping("/AllRequest")
//    public String AllRequest(Model model) {
//        Iterable<Request> requests = requestRepository.findAllByOrderByIdDesc();
//        model.addAttribute("requests", requests);
//        return "AdminHTML/allRequest";
//    }

    @GetMapping("/Infrastructure")
    public String Infrastructure(Model model) {
        model.addAttribute("title", "Инфраструктура");
        return "HomeHTML/infrastructure";
    }

//    @GetMapping("/Price")
//    public String Price(Model model) {
//        model.addAttribute("title", "Прайс");
//        return "HomeHTML/price";
//    }

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
        Iterable<Comment> comments = commentRepository.findAllByOrderByIdDesc();
        model.addAttribute("comments", comments);
        model.addAttribute("title", "Контакты");
        return "HomeHTML/comment";
    }

    @PostMapping("/Comment")
    public String AddComment(
//                                @RequestParam("createDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createDate,
//            @RequestParam String commentDate,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String text,

//                                  @RequestParam String endDay,
//                                  @RequestParam String status,
//                                  @RequestParam String fulfiled,
            Model model) {
        Comment post;
        if (name == "" && email == "") {
            post = new Comment ("Аноним", "E-mail не указан",text, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        else if (email == "") {
            post = new Comment (name, "E-mail не указан",text, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        else if (name == "") {
            post = new Comment ("Аноним", email,text, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        else {
            post = new Comment(name, email, text, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
        commentRepository.save(post);
        return "redirect:/Comment";
//        return "HomeHTML/comment";
    }





    @GetMapping("/Payment")
    public String payment(Model model) {
        model.addAttribute("title", "Оплата");
        return "payment";
    }

//    @GetMapping("/")
//    public String Home(Model model) {
//        model.addAttribute("title", "home");
//        return "home";
//    }


}