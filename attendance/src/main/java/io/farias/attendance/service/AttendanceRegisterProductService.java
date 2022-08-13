package io.farias.attendance.service;

import io.farias.attendance.convert.AttendanceRegisterConvert;
import io.farias.attendance.convert.AttendanceRegisterProductConvert;
import io.farias.attendance.dto.AttendanceRegisterDto;
import io.farias.attendance.dto.AttendanceRegisterProductResponseDto;
import io.farias.attendance.dto.AttendanceRegisterRequestDto;
import io.farias.attendance.dto.ProductDto;
import io.farias.attendance.model.AttendanceRegisterProduct;
import io.farias.attendance.repository.AttendanceRegisterProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceRegisterProductService {

    private final AttendanceRegisterProductRepository repository;

    public Mono<List<AttendanceRegisterProductResponseDto>> save(Long attendanceRegisterId, List<ProductDto> products) {
        return Mono.just(products)
                .flatMapMany(Flux::fromIterable)
                .map(product -> AttendanceRegisterProduct.builder()
                        .attendanceRegisterId(attendanceRegisterId)
                        .product(product.getDescription())
                        .build()
                )
                .flatMap(this.repository::save)
                .map(AttendanceRegisterProductConvert::fromEntityToDto)
                .collect(Collectors.toList());
    }
    /**
    public Mono<AttendanceRegisterDto> update(Integer id, Mono<AttendanceRegisterUpdateRequestDto> registerUpdateRequest) {
        return registerUpdateRequest
                .flatMap(dto -> this.repository
                        .findById(id)
                        .doOnNext(attendanceRegister -> attendanceRegister.withStatusType(dto.getStatusType()))
                )
                .flatMap(this.repository::save)
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }

    public Mono<AttendanceRegisterDto> findById(Integer id) {
        return this.repository
                .findById(id)
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
    public Flux<AttendanceRegisterDto> findAll() {
        return this.repository
                .findAll()
                .map(AttendanceRegisterConvert::fromEntityToDto);
    }
     **/
}
