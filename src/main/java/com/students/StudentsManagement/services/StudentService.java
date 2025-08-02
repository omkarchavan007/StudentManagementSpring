package com.students.StudentsManagement.services;

import com.students.StudentsManagement.entity.Students;

import java.util.List;

public interface StudentService {

    // Services or methods that we are going to provide
    public String saveStudents(Students students);

    public List<Students> SaveallStudents(List<Students> students);


}
