package io.farias.attendance.repository;

import io.farias.attendance.model.Attendence;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendenceRepository extends ReactiveMongoRepository<Attendence, String> {
}
