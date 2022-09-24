package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class labController {

    @RequestMapping("/lab")
    public String labNames(Model model){

        model.addAttribute("firstLab","lab-00-coupling");
        model.addAttribute("secondLab","lab-01-ioc");
        model.addAttribute("thirdLab","lab-02-di");
        model.addAttribute("fourthLab","lab-03-springBoot");
        model.addAttribute("fifthLab","lab-04-springMvc");

        return "lab/lab-list";
    }
}
