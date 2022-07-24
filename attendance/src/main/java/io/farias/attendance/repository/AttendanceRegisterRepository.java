package io.farias.attendance.repository;

import io.farias.attendance.model.AttendanceRegister;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRegisterRepository extends ReactiveMongoRepository<AttendanceRegister, String> {
}
