package com.Aditya.SpringJdbcExample.service;

import com.Aditya.SpringJdbcExample.model.Student;
import com.Aditya.SpringJdbcExample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student s){
        studentRepository.save(s);
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
