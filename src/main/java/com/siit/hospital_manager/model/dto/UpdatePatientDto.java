package com.siit.hospital_manager.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class UpdatePatientDto {
    Integer id;
    @Range(min = 0, max = 120)
    private Integer age;

}
