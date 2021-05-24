package com.company.blog.controllers;







import com.company.blog.models.*;
import com.company.blog.repo.ActualInformationRepository;
import com.company.blog.repo.EventRepository;
import com.company.blog.repo.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
//@RequestMapping("/Request")

public class AccountClientControllers {

//    private static final Logger LOGGER = LoggerFactory.getLogger(AccountClientControllers.class);
//
//    private final DateTimeService dateTimeService;
//
//    @Autowired
//    AccountClientControllers(DateTimeService dateTimeService) {
//        this.dateTimeService = dateTimeService;
//    }

    @Autowired
    private ActualInformationRepository actualInformationRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RequestRepository requestRepository;

  @GetMapping("/MyAccount")
      public String MyAccount(Model model){
      model.addAttribute("title", "Мой аккаунт");
              return "ClientHTML/myAccount";
  }

    @GetMapping("/TimeTable")
    public String TimeTable(Model model){
        model.addAttribute("title", "Расписание");
        return "ClientHTML/timeTable";
    }



    @GetMapping("/ActualInformation")
    public String ViewActualInformation(Model model) {
        Iterable<ActualInformation> ActualInformations = actualInformationRepository.findAllByOrderByIdDesc();
        model.addAttribute("ActualInformations", ActualInformations);
        return "ClientHTML/actualInformation";
    }


    @GetMapping("/Event")
    public String ViewEvent(Model model) {
        Iterable<Event> Events = eventRepository.findAll();
        model.addAttribute("Events", Events);
        return "ClientHTML/event";
    }

    @GetMapping("/Request")
    public String Request(Model model){
        model.addAttribute("title", "Заявки");
        return "ClientHTML/request";
    }

    /*Создать первую часть БД*/

    @PostMapping("/Request")
    public String AddRequestClient(
            // @RequestParam("createDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createDate,
            @RequestParam String korpus,
            @RequestParam String room,
//                                  @RequestParam String fromWhom,
            @RequestParam String text,
            @RequestParam String toWhom,
//                                  @RequestParam String endDay,
//                                  @RequestParam String status,
//                                  @RequestParam String fulfilled,
            Model model) {

        Request  post = new Request (korpus, room,"",text, toWhom,"","", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "");
        requestRepository.save(post);
        return "ClientHTML/request";
    }




//    @PostMapping("Request")
//    public String AddRequestStaff(@RequestParam String startDay,
//                                  @RequestParam String korpus,
//                                  @RequestParam String room,
//                                  @RequestParam String fromWhom,
//                                  @RequestParam String text,
//                                  @RequestParam String toWhom,
//                                  @RequestParam String endDay,
//                                  @RequestParam String status,
//                                  @RequestParam String fulfilled,
//                                  Model model) {
//        Request post = new Request(startDay,korpus,room,fromWhom,text,toWhom,endDay,status,fulfilled);
//        requestRepository.save(post);
//        return "ClientHTML/request";
//    }



//        this.startDay = startDay;
//        this.korpus = korpus;
//        this.room = room;
//        this.fromWhom = fromWhom;
//        this.text = text;
//        this.toWhom = toWhom;
//        this.endDay = endDay;
//        this.status = status;
//        this.fulfilled = fulfilled;
//    @PostMapping("/Request")
////    @PostMapping(value = "date", method = RequestMethod.POST)
//    public String Request( /*@RequestParam("localDate ") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createDate,*/
//                           @RequestParam String nate,
//                           @RequestParam String korpus,
//                           @RequestParam String myRoomId,
//                           @RequestParam String fromWhom,
//                           @RequestParam String textRequest,
//                           @RequestParam String toWhom,
//                        //   @RequestParam("LocalDate ") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createEndDate,
//                           @RequestParam  String EndDate,
//                           @RequestParam String fulfilled,
//                           Model model) {
//
////        LOGGER.info("Processing date: {}", createDate);
////        dateTimeService.processDate(createDate);
//
////        LOGGER.info("Processing date: {}", createEndDate);
////        dateTimeService.processDate(date);
//
//        Request post = new Request (nate, korpus, myRoomId, fromWhom, textRequest, toWhom, EndDate, fulfilled);
//        requestRepository.save(post);
//        return "ClientHTML/request";
//    }



}
