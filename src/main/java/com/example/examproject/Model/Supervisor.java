package com.example.examproject.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany
    private Set<Student> students;


    //  Constructor
    public Supervisor() {

    }

    public Supervisor(int id, String name) {
        this.id = id;
        this.name = name;
    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
