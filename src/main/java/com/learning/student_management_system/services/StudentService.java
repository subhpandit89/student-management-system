package com.learning.student_management_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.student_management_system.customExceptions.StudentNotFoundException;
import com.learning.student_management_system.entities.Student;
import com.learning.student_management_system.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> fetchAllStudents(){
        return studentRepository.findAll();        
    }

    public Optional<Student> getStudentByID(Long idLong){
        return studentRepository.findById(idLong);

    }

    public Student createNewStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudentRecord(Long id, Student student) throws StudentNotFoundException{
        Optional<Student> fetchedStudent =  studentRepository.findById(id);
        if(fetchedStudent.isEmpty()){
            throw new StudentNotFoundException("Student record does not exist in the system, please retry with correct student id");
        }

        Student st = fetchedStudent.get();
        st.setCourses(student.getCourses());

        studentRepository.save(st);

        return st;

    }

}
