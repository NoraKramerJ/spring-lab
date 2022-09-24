package com.cydeo.controller;


import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {


    @RequestMapping("/profile")

    public String profileInfo(Model model){

        Profile profile=new Profile();
        profile.setName("Anna");
        profile.setSurname("Bashman");
        profile.setUserName("Anna02");
        profile.setPhoneNumber("7154896523");
        profile.setEmail("anna76@gmail.com");
        profile.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile",profile);
        model.addAttribute("profile",profile);
        model.addAttribute("profile",profile);
        model.addAttribute("profile",profile);
        model.addAttribute("profile",profile);


        return "profile/profile-info";
    }
}
