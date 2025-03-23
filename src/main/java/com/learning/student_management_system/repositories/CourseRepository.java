package com.learning.student_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.student_management_system.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
