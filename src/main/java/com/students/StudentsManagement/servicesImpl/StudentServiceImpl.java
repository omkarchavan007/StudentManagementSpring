package com.students.StudentsManagement.servicesImpl;

import com.students.StudentsManagement.entity.Students;
import com.students.StudentsManagement.repository.StudentRepo;
import com.students.StudentsManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

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
    public Students getByID(int  id) {
       Optional<Students> students = studentRepo.findById(id);
        return students.orElse(null);
    }
}
