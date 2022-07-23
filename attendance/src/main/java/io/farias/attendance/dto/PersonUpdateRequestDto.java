package io.farias.attendance.dto;

import io.farias.attendance.enums.StatusType;
import lombok.Data;

import java.time.Instant;

@Data
public class PersonUpdateRequestDto {

    private String id;
    private String name;
    private StatusType statusType;
    private String nick;

}
