//package com.company.blog.controllers;
//
//
//import com.company.blog.models.KorpusOneRooms;
//import com.company.blog.models.KorpusTwoRooms;
//import com.company.blog.repo.KorpusOneRoomsRepository;
//import com.company.blog.repo.KorpusTwoRoomsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomeController {
//
//    @Autowired
//    private KorpusOneRoomsRepository korpusOneRoomsRepository;
//    @Autowired
//    private KorpusTwoRoomsRepository korpusTwoRoomsRepository;
//
//
//    @GetMapping("/")
//    public String home(Model model) {
////        Iterable<Tour> tours = tourRepository.findAll();
////        model.addAttribute("tours", tours);
//        Iterable<KorpusOneRooms> Rooms_1k = korpusOneRoomsRepository.findAll();
//        model.addAttribute("Rooms_1k", Rooms_1k);
//        Iterable<KorpusTwoRooms> Rooms_2k = korpusTwoRoomsRepository.findAll();
//        model.addAttribute("Rooms_2k", Rooms_2k);
//        model.addAttribute("title", "С/П 'Озеро Глухое' ");
//        return "home";
//    }
//}
