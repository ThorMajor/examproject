package com.example.examproject.Controller;

import com.example.examproject.Model.Student;
import com.example.examproject.Model.Supervisor;
import com.example.examproject.Repository.StudentRepository;
import com.example.examproject.Repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SupervisorRepository supervisorRepo;

    @GetMapping("/")
    public String index(Model model) {

        List<Student> studentList = new ArrayList<>();
        List<Supervisor> supervisorList = new ArrayList<>();


        model.addAttribute("student", studentList);
        model.addAttribute("supervisor", supervisorList);

        return "student-admin";
    }

}
