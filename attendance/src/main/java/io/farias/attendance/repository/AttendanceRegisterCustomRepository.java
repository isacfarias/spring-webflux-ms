package io.farias.attendance.repository;

import io.farias.attendance.model.AttendanceRegister;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AttendanceRegisterCustomRepository {

    Flux<AttendanceRegister> findAll();
    Mono<AttendanceRegister> findById(Long id);
}
