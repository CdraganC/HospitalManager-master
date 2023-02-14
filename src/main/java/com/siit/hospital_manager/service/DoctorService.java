package com.siit.hospital_manager.service;

import com.siit.hospital_manager.exception.BusinessException;
import com.siit.hospital_manager.model.Doctor;
import com.siit.hospital_manager.model.dto.CreateDoctorDto;
import com.siit.hospital_manager.model.dto.DoctorDto;
import com.siit.hospital_manager.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<DoctorDto> findAll() {
        return doctorRepository
                .findAll()
                .stream()
                .map(Doctor::toDto)
                .toList();
    }

    public void createDoctor(CreateDoctorDto createDoctorDto) {
        Doctor doctor = Doctor.fromDto(createDoctorDto);

        doctorRepository.findByName(createDoctorDto.getName()).ifPresent(doctorInDb -> {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "Doctor already exists!");
        });
        doctorRepository.save(doctor);
    }

    @Transactional
    public void deleteDoctorById(Integer id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(
                () -> new BusinessException(HttpStatus.NOT_FOUND, "Invalid doctor id"));
        doctorRepository.delete(doctor);
    }
}
