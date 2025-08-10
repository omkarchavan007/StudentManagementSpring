package com.students.StudentsManagement.controller;

import com.students.StudentsManagement.entity.Students;
import com.students.StudentsManagement.repository.StudentRepo;
import com.students.StudentsManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;


    //Add Data into DB
    @PostMapping("/AddStudent")
    public ResponseEntity<String> addStudent(@RequestBody Students students) {
         studentService.saveStudents(students);
        return new ResponseEntity<>("Student data Saved ", HttpStatus.CREATED);
    }

    @PostMapping("/addAllStudents")
    public ResponseEntity<List<Students>> addAllStudents(@RequestBody List<Students> students){

       List<Students>  students1= studentService.SaveallStudents(students);
        return new ResponseEntity<>(students1 , HttpStatus.CREATED);
    }

    @GetMapping("/getStudentByID/{id}")
    public ResponseEntity<Students> getByID(@PathVariable("id") int id) {
        Students students = studentService.getByID(id);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Students>> getAllStudents()
    {
        List<Students> studentsList = studentService.getAllStudents();
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    // Update student by their Id
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Students> updateById(@PathVariable("id") int id, @RequestBody Students students)
    {
        Students students1 = studentService.updateByID(id, students);
        return new ResponseEntity<>(students1, HttpStatus.CREATED);
    }

    // Delete Student By id
    @GetMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id)
    {
        studentService.deleteByID(id);
        return new ResponseEntity<>("Student Data deleted" ,HttpStatus.OK);
    }

    // Filter student by their course
    @GetMapping("/filterByCourse")
    public ResponseEntity<List<Students>> filteByCourse(@RequestBody(required = false) String course)
    {
       List<Students> studentsList = studentService.filterByCourse(course);
       return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }
}
