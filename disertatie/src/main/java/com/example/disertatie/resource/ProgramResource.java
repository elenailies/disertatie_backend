package com.example.disertatie.resource;

import com.example.disertatie.model.Program;
import com.example.disertatie.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programs")
public class ProgramResource {

    @Autowired
    private ProgramService programService;

    @GetMapping
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long id) {
        Optional<Program> program = programService.getProgramById(id);
        return program.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Program createProgram(@RequestBody Program program) {
        return programService.saveProgram(program);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program program) {
        if (programService.getProgramById(id).isPresent()) {
            program.setId(id);
            return ResponseEntity.ok(programService.saveProgram(program));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        if (programService.getProgramById(id).isPresent()) {
            programService.deleteProgram(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
