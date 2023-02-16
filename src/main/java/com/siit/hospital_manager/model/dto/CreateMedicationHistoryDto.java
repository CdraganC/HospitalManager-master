package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.MedicationHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@Builder

public class CreateMedicationHistoryDto {
       private Integer id;
        private String medication;
        private String drugName;
        private LocalDateTime medicationFrom;
        private LocalDateTime medicationTo;


}



