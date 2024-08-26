package com.example.disertatie.repo;

import com.example.disertatie.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepo extends JpaRepository<Program, Long> {
}
