package com.example.disertatie.resource;

import com.example.disertatie.model.Program;
import com.example.disertatie.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/program")
public class ProgramResource {

    private final ProgramService programService;

    public ProgramResource(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Program>> getAllPrograms (){
        List <Program> programs = programService.findAllPrograms();
        return new ResponseEntity<>(programs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Program> getProgramById (@PathVariable("id") Long id){
        Program program = programService.findProgramById(id);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Program> addProgram(@RequestBody Program program){
        Program newProgram = programService.addProgram(program);
        return new ResponseEntity<>(newProgram, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Program> updateProgram(@RequestBody Program program){
        Program updateProgram = programService.updateProgram(program);
        return new ResponseEntity<>(updateProgram, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProgram(@PathVariable("id") Long id){
        programService.deleteProgram(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
