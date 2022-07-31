package io.farias.attendance.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@With
@Builder
@Table("attendance_register_product")
public class AttendanceRegisterProduct {

    @Id
    private Integer productId;
    private Integer attendanceRegisterId;
    private String  product;


}
