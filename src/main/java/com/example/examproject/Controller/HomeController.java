package com.example.examproject.Controller;


import com.example.examproject.Repository.StudentRepository;
import com.example.examproject.Repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @GetMapping("/")
    public String index () {

        return "student-admin";
    }

}
