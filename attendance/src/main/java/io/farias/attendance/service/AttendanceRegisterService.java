package io.farias.attendance.service;

import io.farias.attendance.convert.AttendanceRegisterConvert;
import io.farias.attendance.dto.AttendanceRegisterUpdateRequestDto;
import io.farias.attendance.dto.AttendanceRegisterDto;
import io.farias.attendance.dto.AttendanceRegisterRequestDto;
import io.farias.attendance.enums.StatusType;
import io.farias.attendance.repository.AttendanceRegisterRepository;
import io.farias.attendance.repository.impl.AttendanceRegisterRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AttendanceRegisterService {

    private final AttendanceRegisterRepository repository;
    private final AttendanceRegisterRepositoryImpl repositoryImpl;
    private final AttendanceRegisterProductService registerProductService;

    public Mono<AttendanceRegisterDto> save(AttendanceRegisterRequestDto registerRequest) {
        return Mono.just(registerRequest)
                .map(AttendanceRegisterConvert::fromDtoToEntity)
                .map(entity -> entity.withStatusType(StatusType.ACTIVE))
                .map(entity -> entity.withCreated(Instant.now()))
                .flatMap(this.repository::save)
                .map(AttendanceRegisterConvert::fromEntityToDto);

    }
    public Mono<AttendanceRegisterDto> update(Integer id, Mono<AttendanceRegisterUpdateRequestDto> registerUpdateRequest) {
        return registerUpdateRequest
                .flatMap(dto -> this.repository
                        .findById(id)
                        .doOnNext(attendanceRegister -> attendanceRegister.withStatusType(dto.getStatusType()))
                )
                .flatMap(this.repository::save)
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
    public Mono<AttendanceRegisterDto> findById(Long id) {
        return this.repositoryImpl
                .findById(id)
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
    public Flux<AttendanceRegisterDto> findAll() {
        return this.repositoryImpl
                .findAll()
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
}
