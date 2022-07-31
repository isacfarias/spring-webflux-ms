package io.farias.attendance.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.farias.attendance.enums.StatusType;
import lombok.Data;

import java.time.Instant;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PersonUpdateRequestDto {

    private String id;
    private String name;
    private StatusType statusType;
    private String nick;

}
