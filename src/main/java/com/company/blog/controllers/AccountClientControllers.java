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
//        Iterable<Request> requests5 = requestRepository.findAllByOrderByIdDesc();
//        model.addAttribute("requests5", requests5);
        model.addAttribute("title", "Заявки");
        return "ClientHTML/request";
    }

    /*Создать первую часть БД*/

    @PostMapping("/Request")
    public String AddRequestClient(
            // @RequestParam("createDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createDate,
            @RequestParam String level,
            @RequestParam String room,
                                //  @RequestParam String fromWhom,
            @RequestParam String text,
            @RequestParam String toWhom,
//                                  @RequestParam String endDay,
            //@RequestParam String status,
//                                  @RequestParam String fulfiled,
            Model model) {


        Request post;
        if (level == "" ) {
            post = new Request ("В течении дня", room,"Клиент",text, toWhom,"Не выполнено","-", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "");

        }
        else {

        post = new Request (level, room,"Клиент",text, toWhom,"Не выполнено","-", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "");
        }        requestRepository.save(post);


        requestRepository.save(post);
        return "ClientHTML/request";
    }

    @PostMapping("RequestFilter")
    public String AllRequestClientFilter (@RequestParam String filter, Model model) {
        Iterable<Request> requests5;
        if (filter !=null && !filter.isEmpty()){
            requests5 = requestRepository.findAllByRoomOrderByIdDesc(filter);
        }
        else {
//            return "redirect:/Request";
            requests5 = requestRepository.findAllByRoomOrderByIdDesc(filter);
        }
        model.addAttribute("requests5", requests5);

        model.addAttribute("title", "Фильтр");
        return "ClientHTML/request";
    }


}
