package com.company.blog.controllers;


import com.company.blog.models.ActualInformation;
import com.company.blog.models.Event;
import com.company.blog.models.Request;
import com.company.blog.repo.ActualInformationRepository;
import com.company.blog.repo.EventRepository;
import com.company.blog.repo.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AccountStaffControllers {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private ActualInformationRepository actualInformationRepository;


//    @GetMapping("/StaffAccount")
//    public String StaffAccount(Model model) {
//        model.addAttribute("title", "Аккаунт рабочего КОиРЗ");
//        return "StaffHTML/staffAccount";
//    }

    @PostMapping("/StaffAccount")
    public String AddRequestAdmin(
            // @RequestParam("createDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createDate,
                                  @RequestParam String level,
                                  @RequestParam String room,
            @RequestParam String fromWhom,
            @RequestParam String text,
            @RequestParam String toWhom,
//                                  @RequestParam String endDay,
//                                  @RequestParam String status,
//                                  @RequestParam String fulfilled,
            Model model) {

        Request post;
        if (level == "" && room == "" ) {
            post = new Request ("В течении дня", "-",fromWhom, text, toWhom,"Не выполнено","", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "");

        }
        else {

            post = new Request(level, room, fromWhom, text, toWhom, "Не выполнено", "", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "");
        }        requestRepository.save(post);
//        return "StaffHTML/staffAccount";
        return "redirect:/StaffAccount";
    }




    @GetMapping("/StaffAccount")
    public String AllStaffRequest(Model model) {
        Iterable<Request> requests = requestRepository.findAllByOrderByIdDesc();
        model.addAttribute("requests", requests);


        Iterable<Request> requests1 = requestRepository.findElectro();
        model.addAttribute("requests1", requests1);

        Iterable<Request> requests2 = requestRepository.findSantechnik();
        model.addAttribute("requests2", requests2);

        Iterable<Request> requests3 = requestRepository.findKompl();
        model.addAttribute("requests3", requests3);

        Iterable<Request> requests4 = requestRepository.findGornichnaya();
        model.addAttribute("requests4", requests4);

//        Iterable<Request> requests5 = requestRepository.findByElectro1();
//        model.addAttribute("requests5", requests5);
//        return "redirect:/StaffAccount";
        return "StaffHTML/staffAccount";
    }


    /*!!!  Значения из БД занесены в форму редактирования !!!*/

    @GetMapping("/AllRequestStaff/{id}/edit")
    public String AllRequestStaff (@PathVariable(value = "id") long id, Model model) {
        if(!requestRepository.existsById (id)){
            return "redirect:/AllRequestStaff";
        }
        Optional<Request> post = requestRepository.findById(id);
        ArrayList<Request> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "StaffHTML/staffAllRequestEdit";
    }



    @PostMapping("/AllRequestStaff/{id}/edit")
    public String AllRequestStaffUpdate(@PathVariable(value = "id") long id,
                                   // @RequestParam("createDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createDate,
                                   @RequestParam String level,
//                                   @RequestParam String room,
//                                   @RequestParam String fromWhom,
//                                   @RequestParam String text,
//                                   @RequestParam String toWhom,
//                                   @RequestParam String endDay,
                                   @RequestParam String status,
                                   @RequestParam String fulfiled,
                                   Model model) throws Exception {
        Request post = requestRepository.findById(id).orElseThrow(Exception::new);
        post.setLevel(level);
//        post.setRoom(room);
//        post.setFromWhom(fromWhom);
//        post.setText(text);
//        post.setToWhom(toWhom);
        post.setStatus(status);
        post.setFulfiled(fulfiled);
        post.setEndDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        //   post = new Request(korpus, room, fromWhom, text, toWhom, "", "", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")), "");
        requestRepository.save(post);
        return "redirect:/StaffAccount";
    }



    @PostMapping("AllRequestStaffFilter")
    public String AllRequestStaffFilter (@RequestParam String filter, Model model) {
        Iterable<Request> requests1;
        if (filter !=null && !filter.isEmpty()){
            requests1 = requestRepository.findByStatusAndToWhom(filter, "Электромонтер");
        } else {
            requests1 = requestRepository.findElectro();
        }

        Iterable<Request> requests2;
        if (filter !=null && !filter.isEmpty()){
            requests2 = requestRepository.findByStatusAndToWhom(filter, "Сантехник");
        } else {
            requests2 = requestRepository.findSantechnik();
        }

        Iterable<Request> requests3;
        if (filter !=null && !filter.isEmpty()){
            requests3 = requestRepository.findByStatusAndToWhom(filter, "Комплексный_рабочий");
        }
        else {
            requests3 = requestRepository.findKompl();
        }

        Iterable<Request> requests4;
        if (filter !=null && !filter.isEmpty()){
            requests4 = requestRepository.findByStatusAndToWhom(filter, "Горничная");
        } else {
            requests4 = requestRepository.findGornichnaya();
        }

        model.addAttribute("requests1", requests1);
        model.addAttribute("requests2", requests2);
        model.addAttribute("requests3", requests3);
        model.addAttribute("requests4", requests4);
        return "StaffHTML/staffAccount";
    }























    @GetMapping("/StaffEvent")
    public String ViewEventStaff(Model model) {
        Iterable<Event> Events = eventRepository.findAll();
        model.addAttribute("Events", Events);
        return "StaffHTML/staffEvent";
    }


    @GetMapping("/StaffActualInformation")
    public String StaffActualInformation(Model model) {
        Iterable<ActualInformation> ActualInformations = actualInformationRepository.findAll();
        model.addAttribute("ActualInformations", ActualInformations);
        return "StaffHTML/staffActualInformation";
    }

    @GetMapping("/StaffTimeTable")
    public String StaffTimeTable(Model model) {
        model.addAttribute("title", "Расписание");
        return "StaffHTML/staffTimeTable";
    }

}
