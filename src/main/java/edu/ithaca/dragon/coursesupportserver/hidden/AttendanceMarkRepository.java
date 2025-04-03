package edu.ithaca.dragon.coursesupportserver.hidden;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceMarkRepository extends JpaRepository<AttendanceMark, Long>{
    List<AttendanceMark> findByStudentId(String studentId);
    List<AttendanceMark> findByDayNumber(int dayNumber);
    List<AttendanceMark> findByCourseId(String courseId);
}
