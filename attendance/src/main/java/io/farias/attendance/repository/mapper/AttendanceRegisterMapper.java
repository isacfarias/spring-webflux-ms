package io.farias.attendance.repository.mapper;

import io.farias.attendance.enums.AttendenceType;
import io.farias.attendance.enums.StatusType;
import io.farias.attendance.model.AttendanceRegister;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.Instant;

@ReadingConverter
public class AttendanceRegisterMapper implements Converter<Row, AttendanceRegister> {

    @Override
    public AttendanceRegister convert(Row source) {
        return AttendanceRegister.builder()
                .id(source.get("attr_id", Long.class))
                .attendenceType(AttendenceType.valueOf(source.get("attendance_type", String.class)))
                .statusType(StatusType.valueOf(source.get("status_type", String.class)))
                .description(source.get("description", String.class))
                .created(source.get("created", Instant.class))
                .closure(source.get("closure", Instant.class))
                .build();
    }
}
