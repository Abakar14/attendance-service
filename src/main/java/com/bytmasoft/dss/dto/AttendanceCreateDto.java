package com.bytmasoft.dss.dto;

import com.bytmasoft.dss.enums.AttendanceStatus;
import com.bytmasoft.dss.enums.EntityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceCreateDto {

private Long schoolId;

private Long entityId; // Reference ID (student, teacher, employee)

private EntityType entityType;

private AttendanceStatus status;

private String remarks;
}
