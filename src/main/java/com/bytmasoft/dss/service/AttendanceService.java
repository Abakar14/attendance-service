package com.bytmasoft.dss.service;

import com.bytmasoft.dss.dto.AttendanceCreateDto;
import com.bytmasoft.dss.dto.AttendanceDto;
import com.bytmasoft.dss.entity.Attendance;
import com.bytmasoft.dss.enums.EntityType;
import com.bytmasoft.dss.mapper.AttendanceMapper;
import com.bytmasoft.dss.repository.AttendanceRepository;
import com.bytmasoft.dss.utils.AppUtils;
import com.thoughtworks.xstream.core.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AttendanceService {

private final AttendanceRepository attendanceRepository;
private final AttendanceMapper attendanceMapper;
private final AppUtils appUtils;

public AttendanceDto recordAttendance(AttendanceCreateDto attendanceCreateDto) {

	Attendance attendance = attendanceMapper.toEntity(attendanceCreateDto) ;
	attendance.setAddedBy(appUtils.getUsername());
	return attendanceMapper.toDto(attendanceRepository.save(attendance));
}

public List<AttendanceDto> getAttendance(Long entityId, EntityType entityType) {
	List<Attendance> attendances = attendanceRepository.findByEntityIdAndEntityType(entityId, entityType);
	return attendances.stream().map(attendanceMapper::toDto).collect(Collectors.toList());
}

public List<AttendanceDto> getAttendanceReport(EntityType entityType, LocalDate startDate, LocalDate endDate) {
	List<Attendance> attendances =  attendanceRepository.findByEntityTypeAndAttendanceDateBetween(entityType, startDate, endDate);

	return attendances.stream().map(attendanceMapper::toDto).collect(Collectors.toList());
}

public List<AttendanceDto> getAttendanceByEntityId(Long entityId) {
	List<Attendance> attendances =  attendanceRepository.findByEntityId(entityId);

	return attendances.stream().map(attendanceMapper::toDto).collect(Collectors.toList());
}


public List<AttendanceDto> getAttendanceByEntityIdAndDateBetween(Long entityId,LocalDate startDate, LocalDate endDate) {
	List<Attendance> attendances =  attendanceRepository.findByEntityIdAndAttendanceDateBetween(entityId, startDate, endDate);

	return attendances.stream().map(attendanceMapper::toDto).collect(Collectors.toList());
}

}
