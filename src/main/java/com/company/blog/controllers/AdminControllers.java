package com.company.blog.controllers;



import com.company.blog.models.*;
import com.company.blog.repo.*;
import com.company.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminControllers {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ActualInformationRepository actualInformationRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/AdminHome")
    public String Test(Model model) {
        model.addAttribute("title", "Админ");
        return "AdminHTML/adminHome";
    }

   /* Вывод таблицы зарегистрированных пользователей

    @GetMapping("/AllRegistrations")
    public String allRegistrations(Model model) {
        Iterable<Registration> registrations = registrationRepository.findAll();
        model.addAttribute("registrations", registrations);
        return "AdminHTML/allRegistrations";
    }
*/
    /* Вывод таблицы забронировавших пользователей */

    @GetMapping("/AllClients")
    public String AllClients(Model model) {
        Iterable<Booking> bookings = bookingRepository.findAllByOrderByIdDesc();
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
        Iterable<ActualInformation> ActualInformations = actualInformationRepository.findAllByOrderByIdDesc();
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









    /*Создаем страницу*/

    @GetMapping("/AddEvent")
    public String addEvent(Model model) {
        model.addAttribute("title", "Добавление мероприятия");
        return "AdminHTML/addEvent";
    }



    /* Добавить новую информацию */

    @PostMapping("/AddEvent") //AllClients; home; / можо попробовать
    public String AddNewEvent(@RequestParam String text,
                                       Model model) {
        Event post = new Event(text);
        eventRepository.save(post);
        return "AdminHTML/addEvent";
    }

    /* Вывод всей добавленной информации */

    @GetMapping("/AllEvent")
    public String addViewEvent(Model model) {
        Iterable<Event> Events = eventRepository.findAll();
        model.addAttribute("Events", Events);
        return "AdminHTML/AllEvent";
    }

    /*!!!  Значения из БД занесены в форму редактирования !!!*/


    @GetMapping("/AllEvent/{id}/edit")
    public String AllEvent (@PathVariable(value = "id") long event_id, Model model) {
        if(!eventRepository.existsById (event_id)){
            return "redirect:/AllEvent";
        }
        Optional<Event> post = eventRepository.findById(event_id);
        ArrayList<Event> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "AdminHTML/AllEventEdit";
    }

    /*Редактирование информации*/

    @PostMapping("/AllEvent/{id}/edit")
    public String AllEventUpdate(@PathVariable(value = "id") long event_id,
                                 @RequestParam String text,
                                 Model model) throws Exception {
        Event post = eventRepository.findById(event_id).orElseThrow(Exception::new);
        post.setText(text);
        eventRepository.save(post);
        return "redirect:/AllEvent";
    }

    /* Удалить информацию */

    @PostMapping("/AllEvent/{id}/remove")
    public String AllEventDelete(@PathVariable(value = "id") long event_id, Model model) throws Exception {
        Event post = eventRepository.findById(event_id).orElseThrow(Exception::new);
        eventRepository.delete(post);
        return "redirect:/AllEvent";
    }

    /*Создаем страницу аккаунтов*/

    @GetMapping("/Accounts")
    public String Accounts(Model model) {
        Iterable<Role> Roles = roleRepository.findAll();
        Iterable<Account> Accounts = accountRepository.findAll();
      //  List<Account> usergtList = accountRepository.findAll(); // usergtList Iterable
        model.addAttribute("Roles", Roles);
        model.addAttribute("Accounts", Accounts);
      //  model.addAttribute("usergtList", usergtList);
        model.addAttribute("title", "Аккаунты");
        return "AdminHTML/accounts";
    }

    /*Проверка существует ли аккаунт*/

    @PostMapping("/Accounts")
    public String addAccounts(@ModelAttribute("userForm") @Valid Account userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "AdminHTML/accounts";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "AdminHTML/accounts";
        }
        //   return "AdminHTML/accounts";
       return "redirect:/Accounts";
    }

    /*Удалить аккаунт*/

    @PostMapping("/Accounts/{id}/remove")
    public String AccountsDelete(@PathVariable(value = "id") long id, Model model) throws Exception {
        Account post = accountRepository.findById(id).orElseThrow(Exception::new);
        accountRepository.delete(post);
        return "redirect:/Accounts";
    }



}







