package com.siit.hospital_manager.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Builder
public class CreatePatientDto {
    @NotNull(message = "Name can not be null")
    @Pattern(regexp = "[A-Z][a-z]{1,15}+ [A-Z][a-z]{1,15}+")
    @Schema(description = "This is the patients full name. Must start with uppercase letter for each word")
    private String name;
    @Range(min = 1, max = 120)
    @NotNull(message = "Age can't be null")
    private Integer age;
    @NotNull(message = "UserName can not be null")
    private String userName;
    @NotNull(message = "Password can not be null")
    private String password;
    @NotNull(message = "Phone number can not be null")
    @Pattern(regexp="0[0-9]{9}")
    private String phoneNumber;
}
