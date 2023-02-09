package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.Patient;
import lombok.Data;

@Data
public class PatientDto {
    private Integer id;
    private String name;
    private Integer age;

    public PatientDto(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.age = patient.getAge();
    }

}
