package com.mum.assignment3.exercise3_02.b_many_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return students;
    }

    public void setStudentList(List<Student> studentList) {
        this.students = studentList;
    }

    public Course(String courseNumber, String name) {
        this.courseNumber = courseNumber;
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String courseNumber;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL ,mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
