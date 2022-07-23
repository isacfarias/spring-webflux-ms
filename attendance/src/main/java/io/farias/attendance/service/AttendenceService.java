package io.farias.attendance.service;

import io.farias.attendance.dto.AttendenceDto;
import io.farias.attendance.dto.AttendenceRequestDto;
import io.farias.attendance.repository.AttendenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AttendenceService {

    private final AttendenceRepository repository;

    public Mono<AttendenceDto> create(AttendenceRequestDto attendenceRequest) {
        return Mono.just(new AttendenceDto());
    }
}
