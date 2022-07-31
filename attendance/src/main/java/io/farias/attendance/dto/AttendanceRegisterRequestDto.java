package io.farias.attendance.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.farias.attendance.enums.AttendenceType;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AttendanceRegisterRequestDto {

    private AttendenceType attendenceType;
    private String description;
    private PersonDto person;
    private List<ProductDto> products;

}
