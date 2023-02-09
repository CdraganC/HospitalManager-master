package com.siit.hospital_manager.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateDoctorDto {
    @NotNull(message = "Name can not be null")
    @Pattern(regexp = "[A-Z][a-z]{1,15}+ [A-Z][a-z]{1,15}+")
    private String name;
    @NotNull(message = "Specialisation can not be null")
    private String specialisation;
    @NotNull(message = "userName can not be null")
    private String userName;
    @NotNull(message = "Password can not be null")
    private String password;



}
