package com.siit.hospital_manager.service;

import com.siit.hospital_manager.model.Patient;
import com.siit.hospital_manager.model.dto.MedicationHistoryDto;
import com.siit.hospital_manager.repository.MedicationHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationHistoryService {
    private final MedicationHistoryRepository medicationHistoryRepository;

    public List<MedicationHistoryDto> findAll() {
        return medicationHistoryRepository.findAll().stream().map(MedicationHistoryDto::new).toList();

    }

    public List<MedicationHistoryDto> findAllByPatient(Integer id){
        Patient zero = new Patient();
        zero.setId(id);
        return medicationHistoryRepository.findAllByPatient(zero).stream().map(MedicationHistoryDto::new).toList();
    }

}
