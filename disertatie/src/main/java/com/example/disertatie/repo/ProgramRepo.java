package com.example.disertatie.repo;

import com.example.disertatie.model.Category;
import com.example.disertatie.model.Program;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramRepo extends JpaRepository<Program, Long> {

    @Transactional
    void deleteProgramById(Long id);

    Optional<Program> findProgramById(Long id);

}
