package com.company.blog.controllers;


import com.company.blog.models.Payment;
import com.company.blog.models.Staff;
import com.company.blog.models.Tour;
import com.company.blog.repo.PaymentRepository;
import com.company.blog.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TourController {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    /*Создаем страницу*/

    @GetMapping("/AddTour")
    public String addTour(Model model) {
        Iterable<Payment> payments = paymentRepository.findAll();
        model.addAttribute("payments", "payments");
        model.addAttribute("title", "Добавление тура");
        return "AdminHTML/addTour";
    }


    /* Вывод всех добавленных туров */

//    @GetMapping("/AllTour")
//    public String addNewTour(Model model) {
//        Iterable<Tour> tours = tourRepository.findAll();
//        model.addAttribute("tours", "tours");
//        return "AdminHTML/allTour";
//    }
@GetMapping("/AllTour")
public String addNewTour(Model model) {
    Iterable<Payment> payments = paymentRepository.findByPayment();
    model.addAttribute("payments", "payments");
    return "AdminHTML/allTour";
}


    /* Добавить нового сотрудника сотрудников */

    @PostMapping("/AddTour") //AllClients; home; / можо попробовать
    public String AllTour( @RequestParam String tourKorpus,
                           @RequestParam String tourDateIn,
                           @RequestParam String tourDateOut,
                           @RequestParam String tourDays,
                           @RequestParam String tourName,
                           Model model) {
        Tour post = new Tour (tourKorpus, tourDateIn, tourDateOut, tourDays, tourName);
        tourRepository.save(post);
        return "AdminHTML/addTour";
    }

    /* Значения из БД занесены в форму редактирования */

    @GetMapping("/AllTour/{id}/edit")
    public String AllTourEdit (@PathVariable(value = "id") long id, Model model) {
        if(!tourRepository.existsById (id)){
            return "redirect:/AllTour";
        }
        Optional<Tour> post = tourRepository.findById(id);
        ArrayList<Tour> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "AdminHTML/allTourEdit";
    }

    /*Редактирование клиента*/

    @PostMapping("/AllTour/{id}/edit")
    public String AllTourUpdate( @PathVariable(value = "id") long id,
                                 @RequestParam String tourKorpus,
                                 @RequestParam String tourDateIn,
                                 @RequestParam String tourDateOut,
                                 @RequestParam String tourDays,
                                 @RequestParam String tourName,
                                 Model model) throws Exception {
        Tour post = tourRepository.findById(id).orElseThrow(Exception::new);
        post.setTourKorpus(tourKorpus);
        post.setTourDateIn(tourDateIn);
        post.setTourDateOut(tourDateOut);
        post.setTourDays(tourDays);
        post.setTourName(tourName);
        tourRepository.save(post);
        return "redirect:/AllTour";
    }

    /* Удалить тур */

    @PostMapping("/AllTour/{id}/remove")
    public String AllTourDelete(@PathVariable(value = "id") long id, Model model) throws Exception {
        Tour post = tourRepository.findById(id).orElseThrow(Exception::new);
        tourRepository.delete(post);
        return "redirect:/AllTour";
    }
}
