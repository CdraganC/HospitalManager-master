package com.siit.hospital_manager.repository;
import com.siit.hospital_manager.model.DiagnoseHistory;
import com.siit.hospital_manager.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnoseHistoryRepository extends JpaRepository<DiagnoseHistory, Integer> {

    List<DiagnoseHistory> findAllByPatient(Patient id);
}
