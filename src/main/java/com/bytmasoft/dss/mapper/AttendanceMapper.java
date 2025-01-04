package com.bytmasoft.dss.mapper;

import com.bytmasoft.dss.dto.AttendanceCreateDto;
import com.bytmasoft.dss.dto.AttendanceDto;
import com.bytmasoft.dss.entity.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttendanceMapper {

	AttendanceDto toDto(Attendance attendance);
	Attendance toEntity(AttendanceCreateDto attendanceCreateDto);

}
