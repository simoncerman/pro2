package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> getAllCourses();
    Course getCourse(long id);
    void saveCourse(Course course);
    void deleteCourse(long id);
}
