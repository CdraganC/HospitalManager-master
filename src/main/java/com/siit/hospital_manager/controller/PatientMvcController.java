package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.CreatePatientDto;
import com.siit.hospital_manager.model.dto.PatientDto;
import com.siit.hospital_manager.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/mvc/patient")
@RequiredArgsConstructor
public class PatientMvcController {

    private final PatientService patientService;
    @GetMapping("viewAll")
    public String getAllPatients(Model model){
        List<PatientDto> patientsList = patientService.findAll();
        model.addAttribute("patients", patientsList);
        return "patient/viewAll";
    }

    @GetMapping("/create")
    public String createPatientPage(Model model){
        model.addAttribute("patient", CreatePatientDto.builder().build());
        return "/patient/createPatient";
    }

    @PostMapping("/submitCreatePatientForm")
    public String submitCreatePatientForm (@Valid CreatePatientDto createPatientDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            //return to error page if there are validation errors
            return "/validationError";
        }
        try {
            patientService.createPatient(createPatientDto);
        }
        catch (ResponseStatusException exception){
           return "/entityExistsError";
        }
        return "redirect:/dashboard";
    }

}
