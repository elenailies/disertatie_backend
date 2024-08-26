package com.example.disertatie.repo;

import com.example.disertatie.model.Answer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepo extends JpaRepository<Answer, Long> {

    @Transactional
    void deleteAnswerById(Long id);

    Optional<Answer> findAnswerById(Long id);
    List<Answer> findByQuestionId(Long questionId);

}
