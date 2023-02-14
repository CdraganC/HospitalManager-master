package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.CreateDoctorDto;
import com.siit.hospital_manager.model.dto.DoctorDto;
import com.siit.hospital_manager.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/viewAll")
    public String viewAll(Model model){
        List<DoctorDto> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "/doctor/viewAll";
    }

    @GetMapping("/createDoctor")
    public String createDoctor(Model model){
        model.addAttribute("doctor", CreateDoctorDto.builder().build());
        return "/doctor/createDoctor";
    }

    @PostMapping("/submitCreateDoctorForm")
    public String submitCreateDoctorForm(CreateDoctorDto createDoctorDto){
        doctorService.createDoctor(createDoctorDto);
        return "redirect:/mvc/doctor/viewAll";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDoctorById(@PathVariable Integer id){
        doctorService.deleteDoctorById(id);
    }


}
