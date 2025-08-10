package com.students.StudentsManagement.servicesImpl;

import com.students.StudentsManagement.entity.Students;
import com.students.StudentsManagement.exceptionHandeler.ResourceNotFoundException;
import com.students.StudentsManagement.repository.StudentRepo;
import com.students.StudentsManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    //save one student data
    @Override
    public String saveStudents(Students students) {
        Students students1 = studentRepo.save(students);
        return "Students Data Saved.";
    }

    @Override
    public List<Students> SaveallStudents(List<Students> students) {
        List<Students> students1 = studentRepo.saveAll(students);
        return List.of();
    }

    @Override
    public Students getByID(int id) {
        Optional<Students> students = studentRepo.findById(id);
        return students.orElse(null);
    }

    // get all students data
    @Override
    public List<Students> getAllStudents() {
        List<Students> studentsList = studentRepo.findAll();
        return studentsList;
    }

    // update student by their ID
    @Override
    public Students updateByID(int id, @RequestBody Students newData) {

        Students students = studentRepo.findById(id)
                .orElseThrow(() -> new NullPointerException("Id : " + id + "not Found "));

        students.setfName(newData.getfName());
        students.setlName(newData.getlName());
        students.setCity(newData.getCity());
        students.setCourse(newData.getCourse());
        students.setGender(newData.getGender());
        students.setEnrollmentNo(newData.getEnrollmentNo());

        Students students1 = studentRepo.save(students);
        return students1;
    }

    // Delete Student By their id
    @Override
    public Students deleteByID(int id) {
        studentRepo.deleteById(id);
        return null;
    }


    // Filter Students By their Courses
    @Override
    public List<Students> filterByCourse(String course) {

        List<Students> filteredStudents = studentRepo.findAll().stream()
                .filter((k -> course.equalsIgnoreCase(k.getCourse())))
                .collect(Collectors.toList());

        if (filteredStudents.isEmpty())
        {
            throw new ResourceNotFoundException("Students with course : '" + course + "' Not Found ");
        }
        return filteredStudents;

    }

    //Filter by Any Entity
    @Override
    public List<Students> getStudentsByFilters(String fname, String lname, String city, String course, String enrollmentNo) {

        List<Students> studentsList = studentRepo.findAll();
        return List.of();
    }

}
