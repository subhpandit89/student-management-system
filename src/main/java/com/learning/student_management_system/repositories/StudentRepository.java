package com.learning.student_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.student_management_system.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
