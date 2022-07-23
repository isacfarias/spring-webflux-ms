package io.farias.attendance.dto;

import io.farias.attendance.enums.AttendenceType;
import lombok.Data;

import java.util.List;

@Data
public class AttendenceRequestDto {

    private AttendenceType attendenceType;
    private String description;
    private PersonDto person;
    private List<ProductDto> products;

}
