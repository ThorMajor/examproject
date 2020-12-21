package com.example.examproject.Repository;

import com.example.examproject.Model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
}
