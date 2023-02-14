package com.siit.hospital_manager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.constant.Constable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "medication")
@Data
@RequiredArgsConstructor
public class MedicationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String medication;
    private String drugName;
    private LocalDateTime medicationFrom;
    private LocalDateTime medicationTo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Constable formattedDateFromMethod() {
        String dateFormat = "yyyy-MM-dd";
        String formattedDateFrom = medicationFrom.format(DateTimeFormatter.ofPattern(dateFormat));
        return formattedDateFrom;
    }

    public Constable formattedDateToMethod() {
        String dateFormat = "yyyy-MM-dd";
        String formattedDateTo = medicationTo.format(DateTimeFormatter.ofPattern(dateFormat));
        return formattedDateTo;
    }
}
