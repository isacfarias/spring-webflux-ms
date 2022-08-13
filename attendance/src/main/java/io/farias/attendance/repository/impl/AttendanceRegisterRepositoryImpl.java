package io.farias.attendance.repository.impl;

import io.farias.attendance.model.AttendanceRegister;
import io.farias.attendance.repository.AttendanceRegisterCustomRepository;
import io.farias.attendance.repository.mapper.AttendanceRegisterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AttendanceRegisterRepositoryImpl implements AttendanceRegisterCustomRepository {

    private final DatabaseClient client;
    @Override
    public Flux<AttendanceRegister> findAll() {
        final var sql = " select a.*"
                .concat(" from attendance_register a ")
                .concat(" where 1=1 ")
                .concat(" and a.attr_id = :id ");

        return this.client.sql(sql)
                .bind("id", 2)
                .map(new AttendanceRegisterMapper()::convert)
                .all();
    }

    @Override
    public Mono<AttendanceRegister> findById(Long id) {
        final var sql = " select a.* "
                .concat(" from attendance_register a ")
                .concat(" where 1=1 ")
                .concat(" and a.attr_id = :id ");

        return this.client.sql(sql)
                .bind("id", 1)
                .map(new AttendanceRegisterMapper()::convert)
                .first();
    }
}
