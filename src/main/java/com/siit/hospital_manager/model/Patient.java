package com.siit.hospital_manager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name="patients")
@SuperBuilder
@Data
@RequiredArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Patient extends User{
    private String name;
    private Integer age;
    private String phoneNumber;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    List<Appointment> appointments;


}
