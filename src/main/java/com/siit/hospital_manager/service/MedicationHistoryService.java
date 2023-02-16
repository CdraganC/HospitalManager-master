package com.siit.hospital_manager.service;

import com.siit.hospital_manager.controller.MedicationHistoryController;
import com.siit.hospital_manager.model.MedicationHistory;
import com.siit.hospital_manager.model.Patient;
import com.siit.hospital_manager.model.dto.CreateMedicationHistoryDto;
import com.siit.hospital_manager.model.dto.MedicationHistoryDto;
import com.siit.hospital_manager.repository.MedicationHistoryRepository;
import com.siit.hospital_manager.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationHistoryService {
    private final MedicationHistoryRepository medicationHistoryRepository;
    private final PatientRepository patientRepository;

    public List<MedicationHistoryDto> findAll() {
        return medicationHistoryRepository.findAll().stream().map(MedicationHistoryDto::new).toList();

    }

    public List<MedicationHistoryDto> findAllByPatient(Integer id){
        Patient zero = new Patient();
        zero.setId(id);
        return medicationHistoryRepository.findAllByPatient(zero).stream().map(MedicationHistoryDto::new).toList();
    }

    public void addMedicationHistory (CreateMedicationHistoryDto dto, Integer patientId) {
        MedicationHistory history = new MedicationHistory();
        Patient patient = patientRepository.getById(patientId);
        history.setMedication(dto.getMedication());
        history.setPatient(patient);
        history.setDrugName(dto.getDrugName());
        history.setMedicationTo(dto.getMedicationTo());
        history.setMedicationFrom(dto.getMedicationFrom());
        medicationHistoryRepository.save(history);
    }

}
