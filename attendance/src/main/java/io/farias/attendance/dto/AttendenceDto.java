package io.farias.attendance.dto;

import io.farias.attendance.enums.AttendenceType;
import io.farias.attendance.enums.StatusType;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class AttendenceDto {

    private String id;
    private AttendenceType attendenceType;
    private String description;
    private PersonDto person;
    private List<ProductDto> products;
    private StatusType statusType;
    private Instant created;
    private Instant closure;

}
