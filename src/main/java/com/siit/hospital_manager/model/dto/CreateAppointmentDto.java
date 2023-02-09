package com.siit.hospital_manager.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAppointmentDto {
    @NotNull(message = "Date can't be null")
    private String date;
    private Integer doctorId;

}
