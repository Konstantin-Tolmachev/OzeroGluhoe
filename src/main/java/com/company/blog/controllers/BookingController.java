package com.company.blog.controllers;


import com.company.blog.models.Booking;
import com.company.blog.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    /*

    /*Вывод таблицы Booking
      @GetMapping("/AllClients")
      public String AllClients(Model model) {
          Iterable<Booking> bookings = bookingRepository.findAll();
          model.addAttribute("bookings", bookings);
          return "allClients";
      }
  */
    @PostMapping("/") //AllClients; home; / можо попробовать
    public String Payment( @RequestParam String fname,
                           @RequestParam String lname,
                           @RequestParam String pname,
                           @RequestParam String phone,
                           @RequestParam String tourId,
                           @RequestParam String myRoomId,
                           @RequestParam String dateIn,
                           @RequestParam String days,
                            Model model) {
        Booking post = new Booking (fname, lname, pname, phone, tourId, myRoomId, dateIn, days);
        bookingRepository.save(post);
        return "home";
    }


      /* Вывод всех добавленных дат   AllTour
      Добавить вывод на главный экран

    @GetMapping("/home")
    public String addNewTour(Model model) {
        Iterable<Tour> tours = tourRepository.findAll();
        model.addAttribute("tours", tours);
        return "AdminHTML/allTour";
    }
*/



}
