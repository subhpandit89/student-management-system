package com.learning.student_management_system.restControllers;

import org.springframework.web.bind.annotation.RestController;

import com.learning.student_management_system.entities.Course;
import com.learning.student_management_system.services.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/courses")
    public Course postMethodName(@RequestBody Course course) {        
        return courseService.createNewStudent(course);
    }
    
    

}
