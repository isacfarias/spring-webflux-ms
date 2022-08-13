package io.farias.attendance.convert;

import io.farias.attendance.dto.AttendanceRegisterUpdateRequestDto;
import io.farias.attendance.dto.AttendanceRegisterDto;
import io.farias.attendance.dto.AttendanceRegisterRequestDto;
import io.farias.attendance.model.AttendanceRegister;

public class AttendanceRegisterConvert {

    public static AttendanceRegisterDto fromEntityToDto(AttendanceRegister entity) {
        return AttendanceRegisterDto.builder()
                .id(entity.getId())
                .attendenceType(entity.getAttendenceType())
                .description(entity.getDescription())
                .statusType(entity.getStatusType())
                .created(entity.getCreated())
                .closure(entity.getClosure())
                .build();
    }

    public static AttendanceRegister fromDtoToEntity(AttendanceRegisterRequestDto dto) {
        return AttendanceRegister.builder()
                .attendenceType(dto.getAttendenceType())
                .description(dto.getDescription())
                .build();
    }

}
