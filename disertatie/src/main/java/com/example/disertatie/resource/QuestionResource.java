package com.example.disertatie.resource;

import com.example.disertatie.model.Question;
import com.example.disertatie.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/question")
public class QuestionResource {

    private final QuestionService questionService;

    public QuestionResource(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.findAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") Long id) {
        Question question = questionService.findQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        Question newQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        Question updateQuestion = questionService.updateQuestion(question);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
