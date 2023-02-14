package com.siit.hospital_manager.controller;


import com.siit.hospital_manager.config.MyUserDetailsService;
import com.siit.hospital_manager.config.SecurityUtils;
import com.siit.hospital_manager.model.dto.DiagnoseHistoryDto;
import com.siit.hospital_manager.service.DiagnoseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequestMapping("/diagnose")
@Controller
@RequiredArgsConstructor
public class DiagnoseHistoryController {
    private final MyUserDetailsService myUserDetailsService;
    private final DiagnoseHistoryService diagnoseHistoryService;
    public List<DiagnoseHistoryDto> findAll () {
        return diagnoseHistoryService.findAll();

    }
    @GetMapping("/viewAll")
    public String findAllByPatient(Model model, Principal authentication) throws Exception {
        Optional<String> username = SecurityUtils.getCurrentUserLogin();
        if (username.isPresent()) {
            Integer userId = myUserDetailsService.getUserIdByUsername(username.get());
            List<DiagnoseHistoryDto> diagnoseHistory = diagnoseHistoryService.findAllByPatient(userId);
            model.addAttribute("diagnoses", diagnoseHistory);
        }
        else { throw new Exception ("User not found");}
        return "/diagnose/viewAll";
    }
}
