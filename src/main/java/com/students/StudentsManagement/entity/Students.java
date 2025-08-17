package com.students.StudentsManagement.entity;

import jakarta.persistence.*;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fName;
    private String lName;
    private String course;
    private String city;
    private long enrollmentNo;
    private String gender;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private Vehicles vehicles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(long enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", course='" + course + '\'' +
                ", city='" + city + '\'' +
                ", enrollmentNo=" + enrollmentNo +
                ", gender='" + gender + '\'' +
                '}';
    }
}
