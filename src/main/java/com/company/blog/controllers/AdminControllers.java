package com.company.blog.controllers;



import com.company.blog.models.ActualInformation;
import com.company.blog.models.Staff;
import com.company.blog.repo.ActualInformationRepository;
import com.company.blog.repo.BookingRepository;
import com.company.blog.models.Booking;
import com.company.blog.models.Registration;
import com.company.blog.repo.RegistrationRepository;
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
public class AdminControllers {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ActualInformationRepository actualInformationRepository;

    @GetMapping("/AdminHome")
    public String Test(Model model) {
        model.addAttribute("title", "Админ");
        return "AdminHTML/adminHome";
    }

   /* Вывод таблицы зарегистрированных пользователей */

    @GetMapping("/AllRegistrations")
    public String allRegistrations(Model model) {
        Iterable<Registration> registrations = registrationRepository.findAll();
        model.addAttribute("registrations", registrations);
        return "AdminHTML/allRegistrations";
    }

    /* Вывод таблицы забронировавших пользователей */

    @GetMapping("/AllClients")
    public String AllClients(Model model) {
        Iterable<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "AdminHTML/allClients";
    }
    
    /* Значения из БД занесены в форму редактирования */

    @GetMapping("/AllClients/{id}/edit")
    public String AllClientsEdit (@PathVariable(value = "id") long id, Model model) {
        if(!bookingRepository.existsById (id)){
            return "redirect:/AllClients";
        }
        Optional<Booking> post = bookingRepository.findById(id);
        ArrayList<Booking> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "AdminHTML/allClientsEdit";
    }

    /*Редактирование клиента*/

    @PostMapping("/AllClients/{id}/edit")
    public String AllClientsPostUpdate(@PathVariable(value = "id") long id,
                                       @RequestParam String fname,
                                       @RequestParam String lname,
                                       @RequestParam String pname,
                                       @RequestParam String phone,
                                       @RequestParam String tourId,
                                       @RequestParam String myRoomId,
                                       @RequestParam String dateIn,
                                       @RequestParam String days,
                                       Model model) throws Exception {
        Booking post = bookingRepository.findById(id).orElseThrow(Exception::new);
        post.setFname(fname);
        post.setLname(lname);
        post.setPname(pname);
        post.setPhone(phone);
        post.setTourId(tourId);
        post.setMyRoomId(myRoomId);
        post.setMyRoomId(dateIn);
        post.setDays(days);
        bookingRepository.save(post);
        return "redirect:/AllClients";
    }

    /*Удалить клиента*/

    @PostMapping("/AllClients/{id}/remove")
    public String AllClientsPostDelete(@PathVariable(value = "id") long id, Model model) throws Exception {
        Booking post = bookingRepository.findById(id).orElseThrow(Exception::new);
        bookingRepository.delete(post);
        return "redirect:/AllClients";
    }

    /*Создаем страницу*/

    @GetMapping("/AddActualInformation")
    public String addActualInformation(Model model) {
        model.addAttribute("title", "Добавление информации");
        return "AdminHTML/addActualInformation";
    }



    /* Добавить новую информацию */

    @PostMapping("/AddActualInformation") //AllClients; home; / можо попробовать
    public String AllActualInformation(@RequestParam String text,
                           Model model) {
        ActualInformation post = new ActualInformation (text);
        actualInformationRepository.save(post);
        return "AdminHTML/addActualInformation";
    }

    /* Вывод всей добавленной информации */

    @GetMapping("/AllActualInformation")
    public String addNewActualInformation(Model model) {
        Iterable<ActualInformation> ActualInformations = actualInformationRepository.findAll();
        model.addAttribute("ActualInformations", ActualInformations);
        return "AdminHTML/AllActualInformation";
    }

    /*!!!  Значения из БД занесены в форму редактирования !!!*/
    /*!!!  Значения из БД занесены в форму редактирования !!!*/
    /*!!!  Значения из БД занесены в форму редактирования !!!*/
    /*!!!  Значения из БД занесены в форму редактирования !!!*/
    /*!!!  Значения из БД занесены в форму редактирования !!!*/

    @GetMapping("/AllActualInformation/{id}/edit")
    public String AllActualInformation (@PathVariable(value = "id") long id, Model model) {
        if(!actualInformationRepository.existsById (id)){
            return "redirect:/AllActualInformation";
        }
        Optional<ActualInformation> post = actualInformationRepository.findById(id);
        ArrayList<ActualInformation> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "AdminHTML/AllActualInformationEdit";
    }

    /*Редактирование информации*/

    @PostMapping("/AllActualInformation/{id}/edit")
    public String AllStaffUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String text,
                                 Model model) throws Exception {
        ActualInformation post = actualInformationRepository.findById(id).orElseThrow(Exception::new);
        post.setText(text);
       actualInformationRepository.save(post);
        return "redirect:/AllActualInformation";
    }

    /* Удалить информацию */

    @PostMapping("/AllActualInformation/{id}/remove")
    public String AllActualInformationDelete(@PathVariable(value = "id") long id, Model model) throws Exception {
        ActualInformation post = actualInformationRepository.findById(id).orElseThrow(Exception::new);
        actualInformationRepository.delete(post);
        return "redirect:/AllActualInformation";
    }





}







