package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.MedicationHistory;
import lombok.*;

import java.lang.constant.Constable;

@Getter
@Setter
@RequiredArgsConstructor
public class MedicationHistoryDto {

    private Integer id;
    private String medication;
    private String drugName;
    private Constable medicationFrom;
    private Constable medicationTo;

    public MedicationHistoryDto(MedicationHistory medicationHistory) {
        this.id = medicationHistory.getId();
        this.medication = medicationHistory.getMedication();
        this.drugName = medicationHistory.getDrugName();
        this.medicationFrom = medicationHistory.formattedDateFromMethod();
        this.medicationTo = medicationHistory.formattedDateToMethod();
    }

}
