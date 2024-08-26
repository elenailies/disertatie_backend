package com.example.disertatie.service;

import com.example.disertatie.model.Question;
import com.example.disertatie.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepo questionRepository;

    @Autowired
    public QuestionService(QuestionRepo questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public Question findQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found for id: " + id));
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
