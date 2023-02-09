package com.siit.hospital_manager.controller;

import com.siit.hospital_manager.model.dto.*;
import com.siit.hospital_manager.service.AppointmentService;
import com.siit.hospital_manager.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/appointment")

@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;

    @GetMapping("/findAllByPatient")
    public String findAllByPatient(Model model, Principal principal) {
        List<AppointmentDto> appointments = appointmentService.findAllByUserName(principal.getName());
        model.addAttribute("appointments", appointments);

        return "appointment/viewAll";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAppointmentById(@PathVariable Integer id, Principal principal){
         appointmentService.deleteAppointmentByIdAndPatient(id, principal.getName());
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("appointment", CreateAppointmentDto.builder().build());
        model.addAttribute("doctors", doctorService.findAll());

        return "appointment/create";
    }

    @PostMapping("/submitCreateAppointmentForm")
    public String submitCreateAppointmentForm(@Valid CreateAppointmentDto createAppointmentDto, Principal principal){
        appointmentService.createAppointment(createAppointmentDto, principal.getName());
        return "redirect:/appointment/findAllByPatient";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAppointment(@PathVariable Integer id, @Valid @RequestBody UpdateAppointmentDto updateAppointmentDto, Principal principal){
        appointmentService.updateAppointment(id, updateAppointmentDto, principal.getName());
    }

}
