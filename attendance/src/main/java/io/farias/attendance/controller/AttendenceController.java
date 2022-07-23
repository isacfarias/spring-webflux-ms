package io.farias.attendance.controller;

import io.farias.attendance.dto.AttendenceDto;
import io.farias.attendance.dto.AttendenceRequestDto;
import io.farias.attendance.service.AttendenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("attendence")
@RequiredArgsConstructor
public class AttendenceController {

    private final AttendenceService service;


    @PostMapping
    public Mono<AttendenceDto> create(@RequestBody Mono<AttendenceRequestDto> attendence) {
        return attendence.flatMap(this.service::create);
    }


}
