package com.bytmasoft.dss.dto;

import com.bytmasoft.dss.enums.AttendanceStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceDto {

private Long id;

private Long schoolId;

private Long entityId; // Reference ID (student, teacher, employee)

private String entityType; // "STUDENT", "TEACHER", "EMPLOYEE"

@JsonFormat(pattern = "dd.MM.yyyy")
private LocalDate attendanceDate;

@JsonFormat(pattern = "dd.MM.yyyy'T'HH:mm:ss")
private LocalDateTime addedOn;

private AttendanceStatus status;

private String remarks;

}
