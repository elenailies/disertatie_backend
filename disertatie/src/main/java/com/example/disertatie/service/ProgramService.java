package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Program;
import com.example.disertatie.repo.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    private final ProgramRepo programRepo;

    @Autowired
    public ProgramService(ProgramRepo programRepo) {
        this.programRepo = programRepo;
    }

    public Program addProgram(Program program){
        //program.setName(UUID.randomUUID().toString());
        return programRepo.save(program);
    }

    public List<Program> findAllPrograms() {
        return programRepo.findAll();
    }

    public Program updateProgram(Program program){
        return programRepo.save(program);
    }

    public Program findProgramById(Long id){
        return programRepo.findProgramById(id)
                .orElseThrow(() -> new UserNotFoundException("Program by id " + id + " was not found"));
    }

    public void deleteProgram(Long id){
        programRepo.deleteProgramById(id);

    }

}
