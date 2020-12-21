package com.example.examproject.Repository;

import com.example.examproject.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
