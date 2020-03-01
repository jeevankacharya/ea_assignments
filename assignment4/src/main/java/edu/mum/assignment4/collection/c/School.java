package edu.mum.assignment4.collection.c;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "studentId")
    private Map<Integer, Student> students = new HashMap<>();

    public School() {

    }


    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }
}
