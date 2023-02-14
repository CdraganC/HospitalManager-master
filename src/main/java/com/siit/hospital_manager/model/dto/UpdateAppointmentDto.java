package com.siit.hospital_manager.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
public class UpdateAppointmentDto {
    @NotNull(message = "Date can't be null")
    private String date;

}
