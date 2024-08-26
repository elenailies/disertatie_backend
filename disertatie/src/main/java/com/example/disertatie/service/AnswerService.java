package com.example.disertatie.service;

import com.example.disertatie.model.Answer;
import com.example.disertatie.repo.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepo answerRepository;

    @Autowired
    public AnswerService(AnswerRepo answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAllAnswers() {
        return answerRepository.findAll();
    }

    public Answer findAnswerById(Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found for id: " + id));
    }

    public List<Answer> findAnswersByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }
}
