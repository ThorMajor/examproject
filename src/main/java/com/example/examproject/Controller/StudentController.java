package com.example.examproject.Controller;

import com.example.examproject.Model.Student;
import com.example.examproject.Model.Supervisor;
import com.example.examproject.Repository.StudentRepository;
import com.example.examproject.Repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    // Read metode - Læs alle studerende fra studentRepository
    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    // Delete metode - Fjern specifik studerende ( ID )
    @DeleteMapping ("/students/delete{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        System.out.println("Student " + id + " has been deleted.");
    }

    // Create metode - Tilføj studerende
    @PostMapping("/students/add")
    @ResponseBody
    public void createStudent (@ModelAttribute Student student, @RequestParam("supervisor")int id) {
        System.out.println(student.getName());
        Supervisor supervisor = supervisorRepository.findById(id).get();

        student.setSupervisor(supervisor);
        Student newStudent = studentRepository.save(student);
    }
    /*
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        // @RequestBody mapper student details om til bean

        Student savedStudent = studentRepository.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
*/
    // Update metode - Ændr studerendes informationer
    @PutMapping("/students/edit{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        student.setId(id);
        studentRepository.save(student);

        return ResponseEntity.noContent().build();
    }
}