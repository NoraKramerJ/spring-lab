package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

    @RequestMapping("/login/{email}/{phoneNumber}")

    public String login(@PathVariable String email, @PathVariable int phoneNumber, Model model){


        model.addAttribute("email", email);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("loginMessage","Login Successful");
        return "login/login-info";
    }

}
