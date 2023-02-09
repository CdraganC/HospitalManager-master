package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.MedicationHistory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
public class MedicationHistoryDto {

    private Integer id;
    private String medication;
    private String drugName;
    private Date medicationFrom;
    private Date medicationTo;

    public MedicationHistoryDto (MedicationHistory medicationHistory) {
        this.id = medicationHistory.getId();
        this.medication = medicationHistory.getMedication();
        this.drugName = medicationHistory.getDrugName();
        this.medicationFrom = medicationHistory.getMedicationFrom();
        this.medicationTo = medicationHistory.getMedicationTo();
    }
}
