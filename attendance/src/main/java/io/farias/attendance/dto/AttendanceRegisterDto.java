package io.farias.attendance.dto;

import io.farias.attendance.enums.AttendenceType;
import io.farias.attendance.enums.StatusType;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;
import java.util.List;

@Data
@With
@Builder
public class AttendanceRegisterDto {

    private String id;
    private AttendenceType attendenceType;
    private String description;
    private PersonDto person;
    private List<ProductDto> products;
    private StatusType statusType;
    private Instant created;
    private Instant closure;

}