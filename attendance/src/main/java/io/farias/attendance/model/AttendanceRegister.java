package io.farias.attendance.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.farias.attendance.enums.AttendenceType;
import io.farias.attendance.enums.StatusType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.List;

@Data
@With
@Builder
@Table("attendance_register")
public class AttendanceRegister {

    @Id
    private Integer id;
    private AttendenceType attendenceType;
    private String description;
    private StatusType statusType;
    private Instant created;
    private Instant closure;
    @Override
    public String toString() {
        return "AttendanceRegister {" +
                " id=" + id +
                ", attendenceType=" + attendenceType +
                ", description='" + description + '\'' +
                ", statusType=" + statusType +
                ", created=" + created +
                ", closure=" + closure +
                '}';
    }
}
