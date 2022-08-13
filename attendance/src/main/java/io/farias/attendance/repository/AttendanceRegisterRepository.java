package io.farias.attendance.repository;

import io.farias.attendance.model.AttendanceRegister;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRegisterRepository extends ReactiveCrudRepository<AttendanceRegister, Integer>, AttendanceRegisterCustomRepository {
}
