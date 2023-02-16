package com.siit.hospital_manager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.siit.hospital_manager.util.AuthUtils.*;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("message", "Hospital Manager");
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashBoard(Model model, Authentication authentication){
        model.addAttribute("userName", authentication.getName());
        model.addAttribute("isAdmin", isAdmin(authentication));
        model.addAttribute("isPatient", isPatient(authentication));
        model.addAttribute("isDoctor", isDoctor(authentication));


        model.addAttribute("message", "Hospital Manager");
        return "dashboard/dashboard";
    }

}
