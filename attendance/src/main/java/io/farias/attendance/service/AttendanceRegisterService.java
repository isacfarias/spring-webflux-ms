package io.farias.attendance.service;

import io.farias.attendance.convert.AttendanceRegisterConvert;
import io.farias.attendance.dto.AttendanceRegisterUpdateRequestDto;
import io.farias.attendance.dto.AttendanceRegisterDto;
import io.farias.attendance.dto.AttendanceRegisterRequestDto;
import io.farias.attendance.repository.AttendanceRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AttendanceRegisterService {

    private final AttendanceRegisterRepository repository;

    public Mono<AttendanceRegisterDto> create(Mono<AttendanceRegisterRequestDto> registerRequest) {
        return registerRequest
                .map(AttendanceRegisterConvert::fromDtoToEntity)
                .flatMap(this.repository::save)
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
    public Mono<AttendanceRegisterDto> update(String id, Mono<AttendanceRegisterUpdateRequestDto> registerUpdateRequest) {
        return registerUpdateRequest
                .flatMap(dto -> this.repository
                        .findById(id)
                        .doOnNext(attendanceRegister -> attendanceRegister.withStatusType(dto.getStatusType()))
                )
                .flatMap(this.repository::save)
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
    public Mono<AttendanceRegisterDto> findById(String id) {
        return this.repository
                .findById(id)
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
    public Flux<AttendanceRegisterDto> findAll() {
        return this.repository
                .findAll()
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
}
