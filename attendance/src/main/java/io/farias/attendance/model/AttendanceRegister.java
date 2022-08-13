package io.farias.attendance.model;

import io.farias.attendance.enums.AttendenceType;
import io.farias.attendance.enums.StatusType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@With
@Builder
@Table("attendance_register")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(staticName = "of")
public class AttendanceRegister {

    @Id
    @Column("attr_id")
    private Long id;
    @Column("attendance_type")
    private AttendenceType attendenceType;
    private String description;
    @Column("status_type")
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
