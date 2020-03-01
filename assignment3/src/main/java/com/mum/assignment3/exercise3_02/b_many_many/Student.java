package com.mum.assignment3.exercise3_02.b_many_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourseList() {
        return courses;
    }

    public void setCourseList(List<Course> courseList) {
        this.courses = courseList;
    }

    public  Student(){

    }

    @Id
    @GeneratedValue
    private Long studentId;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "STUDENT_COURSES",
            joinColumns = { @JoinColumn(name = "STUDENT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
    private List<Course> courses = new ArrayList<>();

}
