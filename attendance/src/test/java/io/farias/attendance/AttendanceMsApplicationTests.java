package io.farias.attendance;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

@SpringBootTest
class AttendanceMsApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void test() {
		System.out.println(Instant.now());
	}
}
