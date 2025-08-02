package com.students.StudentsManagement.controller;

import com.students.StudentsManagement.entity.Students;
import com.students.StudentsManagement.repository.StudentRepo;
import com.students.StudentsManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;


    //Add Data into DB
    @PostMapping("/AddStudent")
    public ResponseEntity<String> addStudent(@RequestBody Students students) {
        studentService.saveStudents(students);
        return new ResponseEntity<>("Student data Saved ", HttpStatus.OK);
    }

}
