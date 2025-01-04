package com.bytmasoft.dss.controller;

import com.bytmasoft.dss.dto.AttendanceCreateDto;
import com.bytmasoft.dss.dto.AttendanceDto;
import com.bytmasoft.dss.enums.EntityType;
import com.bytmasoft.dss.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/attendance", produces = MediaType.APPLICATION_JSON_VALUE)
public class AttendanceController {

private final AttendanceService attendanceService;

@PreAuthorize("hasAnyAuthority('MANAGE_USERS')")
@PostMapping
public ResponseEntity<AttendanceDto> recordAttendance(@RequestBody AttendanceCreateDto attendanceCreateDto) {
	AttendanceDto savedAttendance = attendanceService.recordAttendance(attendanceCreateDto);
	return ResponseEntity.ok(savedAttendance);
}

@GetMapping("/{entityId}")
public ResponseEntity<List<AttendanceDto>> getAttendance(@PathVariable Long entityId) {
	return ResponseEntity.ok(attendanceService.getAttendanceByEntityId(entityId));
}

@GetMapping("/{entityId}/startdate/enddate")
public ResponseEntity<List<AttendanceDto>> getAttendanceByEntityIdAndDateBetween(@PathVariable Long entityId,@RequestParam LocalDate startDate,
                                                                                 @RequestParam LocalDate endDate
                                                                                 ) {
	return ResponseEntity.ok(attendanceService.getAttendanceByEntityIdAndDateBetween(entityId, startDate, endDate));
}



@GetMapping("/{entityType}/{entityId}")
public ResponseEntity<List<AttendanceDto>> getAttendance(
		@PathVariable EntityType entityType,
		@PathVariable Long entityId) {
	return ResponseEntity.ok(attendanceService.getAttendance(entityId, entityType));
}

@GetMapping("/report/{entityType}")
public ResponseEntity<List<AttendanceDto>> getAttendanceReport(
		@PathVariable EntityType entityType,
		@RequestParam LocalDate startDate,
		@RequestParam LocalDate endDate) {
	return ResponseEntity.ok(attendanceService.getAttendanceReport(entityType, startDate, endDate));
}

}
