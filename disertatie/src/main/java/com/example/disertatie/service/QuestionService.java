package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Question;
import com.example.disertatie.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepo questionRepo;

    @Autowired
    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public Question addQuestion(Question question){
        //question.setName(UUID.randomUUID().toString());
        return questionRepo.save(question);
    }

    public List<Question> findAllQuestions() {
        return questionRepo.findAll();
    }

    public Question updateQuestion(Question question){
        return questionRepo.save(question);
    }

    public Question findQuestionById(Long id){
        return questionRepo.findQuestionById(id)
                .orElseThrow(() -> new UserNotFoundException("Question by id " + id + " was not found"));
    }

    public void deleteQuestion(Long id){
        questionRepo.deleteQuestionById(id);

    }

}
