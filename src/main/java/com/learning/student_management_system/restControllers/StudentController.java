package com.learning.student_management_system.restControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.student_management_system.customExceptions.StudentNotFoundException;
import com.learning.student_management_system.entities.Student;
import com.learning.student_management_system.services.StudentService;
import com.learning.student_management_system.utilities.CustomBean;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CustomBean cusBean;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.fetchAllStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentByID(id);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentService.createNewStudent(student);
    } 
    
    @PutMapping("students/{id}")
    public Student updateStudentData(@PathVariable("id") Long id, @RequestBody Student student) throws StudentNotFoundException {
        Student st;
        try{
            st = studentService.updateStudentRecord(id, student);
        }catch(StudentNotFoundException e){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return st;
    }

    
}
