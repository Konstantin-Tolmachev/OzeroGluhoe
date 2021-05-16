
package com.company.blog.controllers;


import com.company.blog.models.Account;

import com.company.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/Registration")
    public String Registration(Model model) {
        model.addAttribute("userForm", new Account());
        return "HomeHTML/registration";
    }


    @PostMapping("/Registration")
    public String addAccount(@ModelAttribute("userForm") @Valid Account userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "HomeHTML/registration";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "HomeHTML/registration";
        }

        return "redirect:/";
    }
}



