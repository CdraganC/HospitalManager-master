package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.config.MyUserDetailsService;
import com.siit.hospital_manager.config.SecurityUtils;
import com.siit.hospital_manager.model.dto.CreateAppointmentDto;
import com.siit.hospital_manager.model.dto.CreateMedicationHistoryDto;
import com.siit.hospital_manager.model.dto.MedicationHistoryDto;
import com.siit.hospital_manager.service.MedicationHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequestMapping("/medication")
@Controller
@RequiredArgsConstructor
public class MedicationHistoryController {

    private final MyUserDetailsService myUserDetailsService;
    private final MedicationHistoryService medicationHistoryService;
    public List<MedicationHistoryDto> findAll () {
        return medicationHistoryService.findAll();

    }
    @GetMapping("/viewAll")
    public String findAllByPatient(Model model, Principal authentication) throws Exception {
        Optional <String> username = SecurityUtils.getCurrentUserLogin();
        if (username.isPresent()) {
           Integer userId = myUserDetailsService.getUserIdByUsername(username.get());
            List<MedicationHistoryDto> medicationHistory = medicationHistoryService.findAllByPatient(userId);
            model.addAttribute("medications", medicationHistory);
        }
        else { throw new Exception ("User not found");}
        return "/medication/viewAll";
    }

    @GetMapping("/create/{patientId}")
    public String createMedication (Model model, @PathVariable("patientId") Integer patientId) {
        model.addAttribute("medication", CreateMedicationHistoryDto.builder().build());
        return "/medication/create";
    }

    @PostMapping("/create/{patientId}")
    public String create(CreateMedicationHistoryDto medicationHistoryDto, @PathVariable("patientId") Integer patientId) {
    medicationHistoryService.addMedicationHistory(medicationHistoryDto, patientId);

        return "medication/create";
    }

}
