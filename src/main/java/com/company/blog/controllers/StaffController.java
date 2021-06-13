package com.company.blog.controllers;


import com.company.blog.models.Staff;
import com.company.blog.repo.StaffRepository;
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
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    /* Вывод всех добавленных сотрудников */

    @GetMapping("/Staffs")
    public String addNewStaff(Model model) {
        Iterable<Staff> staffs = staffRepository.findAllByOrderByIdDesc();
        model.addAttribute("staffs", staffs);
        return "AdminHTML/staffs";
    }


    /* Добавить нового сотрудника сотрудников */

    @PostMapping("/Staffs") //AllClients; home; / можо попробовать
    public String AllStaff(@RequestParam String fname,
                           @RequestParam String lname,
                           @RequestParam String pname,
                           @RequestParam String position,
                           Model model) {
        Staff post = new Staff (fname, lname, pname, position);
        staffRepository.save(post);
        return "redirect:/Staffs";
    }

    /* Значения из БД занесены в форму редактирования */

    @GetMapping("/Staffs/{id}/edit")
    public String AllStaffEdit (@PathVariable(value = "id") long id, Model model) {
        if(!staffRepository.existsById (id)){
            return "redirect:/Staffs";
        }
        Optional<Staff> post = staffRepository.findById(id);
        ArrayList<Staff> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "AdminHTML/staffsEdit";
    }

    /*Редактирование клиента*/

    @PostMapping("/Staffs/{id}/edit")
    public String AllStaffUpdate(@PathVariable(value = "id") long id,
                                       @RequestParam String fname,
                                       @RequestParam String lname,
                                       @RequestParam String pname,
                                       @RequestParam String position,
                                       Model model) throws Exception {
        Staff post = staffRepository.findById(id).orElseThrow(Exception::new);
        post.setFname(fname);
        post.setLname(lname);
        post.setPname(pname);
        post.setPosition(position);
        staffRepository.save(post);
        return "redirect:/Staffs";
    }

    /* Удалить сотрудника */

    @PostMapping("/Staffs/{id}/remove")
    public String AllStaffDelete(@PathVariable(value = "id") long id, Model model) throws Exception {
        Staff post = staffRepository.findById(id).orElseThrow(Exception::new);
        staffRepository.delete(post);
        return "redirect:/Staffs";
    }

    @PostMapping("StaffFilter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Staff> staffs;

        if (filter !=null && !filter.isEmpty()){
            staffs = staffRepository.findByPosition(filter);
        } else {
            staffs = staffRepository.findAll();
        }

        model.addAttribute("staffs", staffs);
        return "staffs";
    }

}
