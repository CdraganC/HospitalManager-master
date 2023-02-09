package com.siit.hospital_manager.controller.api;

import com.siit.hospital_manager.model.dto.*;
import com.siit.hospital_manager.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patient")
public class PatientApiController {

    private final PatientService patientService;

    public PatientApiController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(description = "get all patients")
    public List<PatientDto> findAll(){
        return patientService.findAll();
    }

    @GetMapping("{id}")
    public PatientDto findById(@PathVariable("id") Integer id) {
        return patientService.findById(id);
    }

    @PostMapping("/create")
    @Operation(summary = "This is for creating patients", description = "This is the long description",
            responses = {@ApiResponse(responseCode = "201", description = "All went well"),
                    @ApiResponse(responseCode = "400", description = "Some field is invalid or missing")}
    )
    public ResponseEntity createUser(@Valid @RequestBody CreatePatientDto createPatientDto){
        return ResponseEntity.status(201).body(Map.of("Id", patientService.createPatient(createPatientDto)));
    }

    @PatchMapping
    public void updatePatient(@RequestBody @Valid UpdatePatientDto updatePatientDto){
        patientService.updatePatient(updatePatientDto);
    }

}
