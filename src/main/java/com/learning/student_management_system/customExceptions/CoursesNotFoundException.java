package com.learning.student_management_system.customExceptions;

public class CoursesNotFoundException extends Exception {

    CoursesNotFoundException(String message){
        super(message);
    }

}
