package com.learning.student_management_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.student_management_system.entities.Course;
import com.learning.student_management_system.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseByID(long id){
        return courseRepository.findById(id);
    }

    public Course createNewStudent(Course course){
        return courseRepository.save(course);
    }

}
