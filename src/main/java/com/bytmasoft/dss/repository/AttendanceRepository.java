package com.bytmasoft.dss.repository;

import com.bytmasoft.dss.entity.Attendance;
import com.bytmasoft.dss.enums.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

List<Attendance> findByEntityId(Long entityId);

List<Attendance> findByEntityIdAndEntityType(Long entityId, EntityType entityType);

List<Attendance> findByEntityIdAndAttendanceDateBetween(Long entityId, LocalDate startDate, LocalDate endDate);

List<Attendance> findByEntityTypeAndAttendanceDateBetween(EntityType entityType, LocalDate startDate, LocalDate endDate);
}
