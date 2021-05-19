package com.company.blog.controllers;


import com.company.blog.models.Booking;
import com.company.blog.repo.BookingRepository;
import com.company.blog.repo.KorpusOneRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;
//    @Autowired
//    private KorpusOneRoomsRepository korpusOneRoomsRepository;

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
                           @RequestParam String dateIn,
                           @RequestParam String dateOut,
                           @RequestParam String korpus,
                           @RequestParam String myRoomId,
                            Model model) {
        Booking post = new Booking (fname, lname, pname, phone, dateIn, dateOut, korpus, myRoomId);
        bookingRepository.save(post);
        return "home";
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

//    @PostMapping("Rooms_1kFilter")
//    public String filter(@RequestParam String filter, Model model) {
//        Iterable<Room_1k> room_1ks;
//
//        if (filter !=null && !filter.isEmpty()){
//            room_1ks = room_1kRepository.findByFree_1k(filter);
//        } else {
//            room_1ks = room_1kRepository.findAll();
//        }
//
//        model.addAttribute("room_1ks", room_1ks);
//        return "AdminHTML/room_1k";
//    }



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
