package com.example.examproject.Controller;

import com.example.examproject.Model.Student;
import com.example.examproject.Model.Supervisor;
import com.example.examproject.Repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SupervisorController {

    @Autowired
    private SupervisorRepository supervisorRepository;

    // Read metode - Læs alle supervisors fra studentRepository

    @GetMapping("/supervisors")
    public List<Supervisor> retrieveAllSupervisors() {
        return supervisorRepository.findAll();
    }


    // Delete metode - Fjern specifik supervisor ( ID )

    @DeleteMapping("/supervisors/delete{id}")
    public void deleteStudent(@PathVariable Integer id) {
        supervisorRepository.deleteById(id);
        System.out.println("Student " + id + " has been deleted.");
    }

    // Create metode - Tilføj supervisor

    @PostMapping("/supervisors")
    public void createSupervisor(@RequestBody Supervisor supervisor) {
        Supervisor savedSupervisor = supervisorRepository.save(supervisor);
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
    // Update metode - Ændr supervisors informationer
    @PutMapping("/supervisor/{id}")
    public ResponseEntity<Object> updateSupervisor(@RequestBody Supervisor supervisor, @PathVariable int id) {
        Optional<Supervisor> studentOptional = supervisorRepository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        supervisor.setId(id);
        supervisorRepository.save(supervisor);

        return ResponseEntity.noContent().build();


    }
}
