package com.students.StudentsManagement.repository;

import com.students.StudentsManagement.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students, Integer> {

}
