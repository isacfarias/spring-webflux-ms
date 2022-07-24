package io.farias.attendance.controller;

import io.farias.attendance.dto.AttendanceRegisterDto;
import io.farias.attendance.dto.AttendanceRegisterRequestDto;
import io.farias.attendance.dto.AttendanceRegisterUpdateRequestDto;
import io.farias.attendance.service.AttendanceRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("attendance-register")
@RequiredArgsConstructor
public class AttendanceRegisterController {

    private final AttendanceRegisterService service;

    @GetMapping
    public Flux<AttendanceRegisterDto> findAll() {
        return this.service.findAll();
    }
    @GetMapping("/{id}")
    public Mono<AttendanceRegisterDto> findById(@PathVariable String id) {
        return Mono
                .just(id)
                .flatMap(this.service::findById);
    }
    @PostMapping
    public Mono<AttendanceRegisterDto> create(@RequestBody Mono<AttendanceRegisterRequestDto> attendanceRegisterRequest) {
        return this.service.create(attendanceRegisterRequest);
    }
    @PutMapping("/{id}")
    public Mono<AttendanceRegisterDto> update(@PathVariable String id, @RequestBody Mono<AttendanceRegisterUpdateRequestDto> attendanceRegisterUpdateRequest) {
        return this.service.update(id, attendanceRegisterUpdateRequest);
    }

}
