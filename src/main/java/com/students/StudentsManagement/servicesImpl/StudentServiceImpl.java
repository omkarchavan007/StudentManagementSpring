package com.students.StudentsManagement.servicesImpl;

import com.students.StudentsManagement.entity.Students;
import com.students.StudentsManagement.repository.StudentRepo;
import com.students.StudentsManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String saveStudents(Students students) {
        Students students1 = studentRepo.save(students);
        return "Students Data Saved.";
    }
}
