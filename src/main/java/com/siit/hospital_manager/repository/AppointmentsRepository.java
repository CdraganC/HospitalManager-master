package com.siit.hospital_manager.repository;

import com.siit.hospital_manager.model.Appointment;
import com.siit.hospital_manager.model.Patient;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findAllByPatientId(Integer id);
    Optional<Appointment> findAppointmentByIdAndPatient(Integer id, Patient patient);
    @Modifying
    @Query(value = "DELETE FROM appointments where id = :id", nativeQuery = true)
    void deleteByIdNativeQuery(@Param("id") Integer id);

}
