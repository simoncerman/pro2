package cz.uhk.kpro2.repository;

import cz.uhk.kpro2.model.Course;
import cz.uhk.kpro2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
