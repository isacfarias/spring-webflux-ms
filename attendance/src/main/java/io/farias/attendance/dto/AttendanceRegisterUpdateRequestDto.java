package io.farias.attendance.dto;

import io.farias.attendance.enums.StatusType;
import lombok.Data;

@Data
public class AttendanceRegisterUpdateRequestDto {

    private StatusType statusType;

}
