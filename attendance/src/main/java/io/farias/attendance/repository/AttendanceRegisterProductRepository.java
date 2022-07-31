package io.farias.attendance.repository;

import io.farias.attendance.model.AttendanceRegisterProduct;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRegisterProductRepository extends ReactiveCrudRepository <AttendanceRegisterProduct, Integer>{
}
