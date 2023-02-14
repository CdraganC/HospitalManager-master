package com.siit.hospital_manager.model.dto;

import com.siit.hospital_manager.model.DiagnoseHistory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DiagnoseHistoryDto {
    private Integer id;
    private String diagnose;
    private String name;
    private String description;

    public DiagnoseHistoryDto (DiagnoseHistory diagnoseHistory) {
        this.id = diagnoseHistory.getId();
        this.diagnose = diagnoseHistory.getDiagnose();
        this.name = diagnoseHistory.getName();
        this.description = diagnoseHistory.getDescription();
    }
}
