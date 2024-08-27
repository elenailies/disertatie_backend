package com.example.disertatie.repo;

import com.example.disertatie.model.Category;
import com.example.disertatie.model.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    @Transactional
    void deleteQuestionById(Long id);

    Optional<Question> findQuestionById(Long id);

}
