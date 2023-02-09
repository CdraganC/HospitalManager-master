package com.siit.hospital_manager.model;

import com.siit.hospital_manager.model.dto.CreateDoctorDto;
import com.siit.hospital_manager.model.dto.DoctorDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name="doctors")
@Data
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@SuperBuilder
@NoArgsConstructor
public class Doctor extends User{
    private String name;
    private String specialisation;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    List<Appointment> appointments;


    public DoctorDto toDto() {
        return DoctorDto
                .builder()
                .name(name)
                .id(getId())
                .specialisation(specialisation)
                .build();
    }

    public static Doctor fromDto(CreateDoctorDto createDoctorDto){
        return Doctor
                .builder()
                .userName(createDoctorDto.getUserName())
                .name(createDoctorDto.getName())
                .specialisation(createDoctorDto.getSpecialisation())
                .password(createDoctorDto.getPassword())
                .isActive(true)
                .roles("ROLE_DOCTOR")
                .build();
    }
}
