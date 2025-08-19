package com.students.StudentsManagement.controller;

import com.students.StudentsManagement.entity.Students;
import com.students.StudentsManagement.services.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;


    // adding logger
    private static final Logger logger = (Logger) LoggerFactory.getLogger(StudentsController.class);


    //Add Data into DB
//    @PostMapping("/AddStudent")
//    public ResponseEntity<String> addStudent(@RequestBody Students students) {
//         studentService.saveStudents(students);
//        return new ResponseEntity<>("Student data Saved ", HttpStatus.CREATED);
//    }

    // Add Students With Vehicle Mapping


    // added with vehicle mapping
    @PostMapping("/addData")
    public ResponseEntity<String> addStudents(@RequestBody Students Students) {

        // Ensure the bidirectional mapping is set
        if (Students.getVehicles() != null) {
            Students.getVehicles().forEach(vehicle -> vehicle.setStudents(Students));
        }

        System.err.println(Students);
        studentService.saveStudents(Students);

        return new ResponseEntity<>("Students Data Saved", HttpStatus.CREATED);
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

        logger.info("INFO: /getAllStudents endpoint was called");
        logger.debug("DEBUG: Detailed debug message");
        logger.error("ERROR: Just an error example");

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
    public ResponseEntity<List<Students>> filterByCourse(@RequestParam(required = false) String course)
    {
       List<Students> studentsList = studentService.filterByCourse(course);
       return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    // filter by Gender
    @GetMapping("/filterByGender")
    public ResponseEntity<List<Students>> filterByGender(@RequestParam(required = false) String gender)
    {
        List<Students> studentsList = studentService.filterByCourse(gender);
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    // filter by City
    @GetMapping("/filterByCity")
    public ResponseEntity<List<Students>> filterByCity(@RequestParam(required = false) String city)
    {
        List<Students> studentsList = studentService.filterByCourse(city);
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    // filter by FirstName
    @GetMapping("/filterByfName")
    public ResponseEntity<List<Students>> filterByfName(@RequestParam(required = false) String fName)
    {
        List<Students> studentsList = studentService.filterByCourse(fName);
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    // filter by LastName
    @GetMapping("/filterBylName")
    public ResponseEntity<List<Students>> filterBylName(@RequestParam(required = false) String lName)
    {
        List<Students> studentsList = studentService.filterByCourse(lName);
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }
}
