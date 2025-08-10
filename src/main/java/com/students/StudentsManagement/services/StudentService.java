package com.students.StudentsManagement.services;

import com.students.StudentsManagement.entity.Students;

import java.util.List;

public interface StudentService {

    // Services or methods that we are going to provide
    // Add single student data at once
    public String saveStudents(Students students);

    //Add List of Students at once
    public List<Students> SaveallStudents(List<Students> students);

    //Get student by id
    public Students getByID(int id);

    // Get all Students
    List<Students> getAllStudents();

    // Update Stuent By ID
    public Students updateByID(int id , Students newData);

    // Delete Studednt by their id
    Students deleteByID(int id);

    // filter student by their courses
    List<Students> filterByCourse(String course);

    // Filter by any Entity
    List<Students> getStudentsByFilters(String name, String lastName, String city, String course, String enrollmentNo);





}
