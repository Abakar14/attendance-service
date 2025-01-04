package com.bytmasoft.dss.entity;

import com.bytmasoft.common.entities.BaseEntity;
import com.bytmasoft.dss.enums.AttendanceStatus;
import com.bytmasoft.dss.enums.EntityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "attendance")
public class Attendance extends BaseEntity implements Serializable {

@Column(nullable = false)
private Long schoolId;

@Column(nullable = false)
private Long entityId; // Reference ID (student, teacher, employee)

@Column(nullable = false)
private EntityType entityType; // "STUDENT", "TEACHER", "EMPLOYEE"

@Column(nullable = false, updatable = false)
@Builder.Default
private LocalDate attendanceDate = LocalDate.now();

@Enumerated(EnumType.STRING)
private AttendanceStatus status;

@Column
private String remarks;



}
