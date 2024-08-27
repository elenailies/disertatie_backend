package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Answer;
import com.example.disertatie.repo.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepo answerRepo;

    @Autowired
    public AnswerService(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    public Answer addAnswer(Answer answer){
        //answer.setName(UUID.randomUUID().toString());
        return answerRepo.save(answer);
    }

    public List<Answer> findAllAnswers() {
        return answerRepo.findAll();
    }

    public Answer updateAnswer(Answer answer){
        return answerRepo.save(answer);
    }

    public Answer findAnswerById(Long id){
        return answerRepo.findAnswerById(id)
                .orElseThrow(() -> new UserNotFoundException("Answer by id " + id + " was not found"));
    }

    public void deleteAnswer(Long id){
        answerRepo.deleteAnswerById(id);

    }

}
