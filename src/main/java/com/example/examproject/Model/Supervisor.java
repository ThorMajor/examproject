package com.example.examproject.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

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

}
