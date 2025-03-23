package com.learning.student_management_system.customExceptions;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message){
        super(message);
    }
}
