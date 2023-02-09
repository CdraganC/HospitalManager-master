package com.siit.hospital_manager.model;

import com.siit.hospital_manager.model.dto.AppointmentDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "appointments")
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public AppointmentDto toDto(){
        String dateFormat = "MMM dd HH:mm";
        String formattedDate = date.format(DateTimeFormatter.ofPattern(dateFormat));

        return AppointmentDto
                .builder()
                .id(id)
                .date(formattedDate)
                .patient(patient)
                .doctor(doctor)
                .build();
    }
}
