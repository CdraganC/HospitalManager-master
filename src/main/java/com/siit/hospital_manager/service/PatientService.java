package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Patient;
import com.siit.hospital_manager.model.User;
import com.siit.hospital_manager.model.dto.*;
import com.siit.hospital_manager.repository.PatientRepository;
import com.siit.hospital_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public List<PatientDto> findAll() {
        return patientRepository.findAll()
                .stream()
                .map(PatientDto::new).toList();
    }

    public PatientDto findById(Integer id) {
        Patient patient = patientRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Patient with id " + id + " not found"));
        return new PatientDto(patient);
    }


    @Transactional
    public Integer createPatient(CreatePatientDto createPatientDto) {

        userRepository.findByUserName(createPatientDto.getUserName()).ifPresent(user -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient already exists!");
                }
        );

        User patient = Patient.builder()
                .userName(createPatientDto.getUserName())
                .password(passwordEncoder.encode(createPatientDto.getPassword()))
                .name(createPatientDto.getName())
                .age(createPatientDto.getAge())
                .isActive(true)
                .roles("ROLE_PATIENT")
                .phoneNumber(createPatientDto.getPhoneNumber())
                .build();
        return userRepository.save(patient).getId();
    }

    public void updatePatient(UpdatePatientDto updatePatientDto) {
        Patient patient = patientRepository
                .findById(updatePatientDto.getId())
                .orElseThrow(() -> new BusinessException(HttpStatus.BAD_REQUEST, "Patient with id " + updatePatientDto.getId() + " not found"));

        if (updatePatientDto.getAge() != null) {
            patient.setAge(updatePatientDto.getAge());
        }
        patientRepository.save(patient);
    }

    // same for delete
}
