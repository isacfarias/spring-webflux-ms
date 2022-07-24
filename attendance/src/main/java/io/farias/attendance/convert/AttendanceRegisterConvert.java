package io.farias.attendance.convert;

import io.farias.attendance.dto.AttendanceRegisterUpdateRequestDto;
import io.farias.attendance.dto.AttendanceRegisterDto;
import io.farias.attendance.dto.AttendanceRegisterRequestDto;
import io.farias.attendance.model.AttendanceRegister;

public class AttendanceRegisterConvert {

    public static AttendanceRegisterDto fromEntityToDto(AttendanceRegister attendanceRegister) {
        return AttendanceRegisterDto.builder()
                .build();
    }

    public static AttendanceRegister fromDtoToEntity(AttendanceRegisterRequestDto registerRequestDto) {
        return AttendanceRegister.builder().build();
    }

    public static AttendanceRegister fromDtoToEntity(AttendanceRegisterUpdateRequestDto registerRequestDto) {
        return AttendanceRegister.builder().build();
    }
}
